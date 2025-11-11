package org.samuel.Controlers;

import org.samuel.Validador.EstadoIncripcion;
import org.samuel.Validador.Validaciones;
import org.samuel.models.Cursos;
import org.samuel.models.Estudiante;
import org.samuel.models.Inscripcion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;

public class ControlerInscripciones {
    private Validaciones validaciones;
    private ArrayList<Inscripcion> inscripcions;

    public ControlerInscripciones() {
        this.validaciones = new Validaciones();
        this.inscripcions = new ArrayList<>();
    }

    public Validaciones getValidaciones() {
        return validaciones;
    }

    public void setValidaciones(Validaciones validaciones) {
        this.validaciones = validaciones;
    }

    public ArrayList<Inscripcion> getInscripcions() {
        return inscripcions;
    }

    public void setInscripcions(ArrayList<Inscripcion> inscripcions) {
        this.inscripcions = inscripcions;
    }

    public void setIncricion(Inscripcion incricion){
        this.inscripcions.add(incricion);
    }

    public int  registrarEstudiante( ControlerEstudiantes estudiante, ControlerCursos crso, int numeroInscritos) {
        String codigo = this.getValidaciones().codigo("ingresa el código del estudiante al que quieres register: ");
        Estudiante estudiante1 = estudiante.getGestorEstudiantes().buscarCodigo(codigo);
        String codigocurso = this.getValidaciones().codigo("ingresa el código del curso  al que quieres register: ");
        Cursos curso = crso.buscarCurso(codigocurso);
        if (crso.buscarCurso(codigocurso).getCarreraRequisito() == null || crso.buscarCurso(codigocurso).getPromedioRequisito() == 0 || crso.buscarCurso(codigocurso).getSemestreRequisito() == 0 || crso.buscarCurso(codigocurso).getCupoMaximo() == 0) {
            System.out.println("no han definido los prerrequisitos defines y registra al estudiante");
            return numeroInscritos;
        } else if (curso.getHorario() == null) {
            System.out.println("no han definido los horarios  defines y registra al estudiante");
            return numeroInscritos;
        } else if (curso.getCupoMaximo() == 0) {
            System.out.println("no han definido el cupo maximo de estudiantes: ");
            return numeroInscritos;
        } else if (curso.getCupoMaximo() <= curso.getNumeroInscripciones()) {
            System.out.println("Ya esta al tope de inscripciones");
            return numeroInscritos;
        } else {
            if (estudiante1.getCarrera() == curso.getCarreraRequisito() && estudiante1.getSemestreActual() == curso.getSemestreRequisito() && estudiante1.getPromedioAcumulado() >= curso.getPromedioRequisito()) {
                String codigoEstudiante = estudiante1.getCodigo();
                String codigoCurso = curso.getCodigo();
                LocalDate  actual = LocalDate.now();
                Inscripcion inscripcio = new Inscripcion(codigoEstudiante,actual, EstadoIncripcion.ACTIVA,codigoCurso);
                this.setIncricion(inscripcio);
                return numeroInscritos + 1;
            }else{
                System.out.println("El estudiante no cumple con los requisitos");
                return numeroInscritos;
            }
        }
    }
}
