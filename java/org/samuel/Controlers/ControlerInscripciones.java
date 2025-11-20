package org.samuel.Controlers;

import org.samuel.Validador.EstadoIncripcion;
import org.samuel.Validador.Validaciones;
import org.samuel.models.Cursos;
import org.samuel.models.Estudiante;
import org.samuel.models.Inscripcion;

import java.time.LocalDate;
import java.util.ArrayList;

public class ControlerInscripciones {
    private Validaciones validaciones;
    private ArrayList<Inscripcion> inscripcions;
    private ArrayList<Estudiante>ListaDeEspera;

    public ControlerInscripciones() {
        this.validaciones = new Validaciones();
        this.inscripcions = new ArrayList<>();
        this.ListaDeEspera = new ArrayList<>();
    }

    public void ingresarAListaDeEspera(Estudiante estudiante){
        this.ListaDeEspera.add(estudiante);
    }

    public Validaciones getValidaciones() {
        return validaciones;
    }

    public ArrayList<Estudiante> getListaDeEspera() {
        return ListaDeEspera;
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

    public void agregar(Inscripcion inscripcion){
        this.inscripcions.add(inscripcion);
    }


    /*
    * En este se crea un curso sin el profesor
    * */
    public void  registrarEstudiante( ControlerEstudiantes estudiante, ControlerCursos crso) {
        String codigo = this.getValidaciones().codigo("ingresa el código del estudiante al que quieres register: ");
        Estudiante estudiante1 = estudiante.getGestorEstudiantes().buscarCodigo(codigo);
        String codigoCurso = this.getValidaciones().codigo("ingresa el código del curso  al que quieres register: ");
        if (crso.buscarCurso(codigoCurso).getCarreraRequisito() == null || crso.buscarCurso(codigoCurso).getPromedioRequisito() == 0 || crso.buscarCurso(codigoCurso).getSemestreRequisito() == 0 || crso.buscarCurso(codigoCurso).getCupoMaximo() == 0) {
            System.out.println("no han definido los prerrequisitos defines y registra al estudiante");
        } else if (crso.buscarCurso(codigoCurso).getHorario() == null) {
            System.out.println("no han definido los horarios  defines y registra al estudiante");
        } else if (crso.buscarCurso(codigoCurso).getCupoMaximo() == 0) {
            System.out.println("no han definido el cupo maximo de estudiantes: ");
        } else if (crso.buscarCurso(codigo).hayCuposDisponibles()) {
            System.out.println("Ya esta al tope de inscripciones");
            System.out.println("te pondremos en lista de espera");
            this.ingresarAListaDeEspera(estudiante1);
        } else {
            if (crso.buscarCurso(codigo).validarRequisitos(estudiante1, crso.buscarCurso(codigoCurso)) && crso.buscarCurso(codigoCurso) != null && estudiante1 != null && crso.buscarCurso(codigoCurso).getCodigoProfesor() != null ) {
                String codigoEstudiante = estudiante1.getCodigo();
                LocalDate  actual = LocalDate.now();
                String codigoInscripcion = this.getValidaciones().generarCodigo();
                System.out.println("Codigo de inscripcion generado: " + codigoInscripcion + " recuerdalo muy bien lo vas a necesitar.");
                Inscripcion inscripcion = new Inscripcion(codigoEstudiante,actual,EstadoIncripcion.ACTIVA,codigoCurso,codigoInscripcion);
                this.setIncricion(inscripcion);
                crso.buscarCurso(codigoCurso).addEstudiante(estudiante1);
                crso.buscarCurso(codigoCurso).setNumeroInscripciones(crso.buscarCurso(codigoCurso).getEstudiantesInscritos().size());
                System.out.println("El estudiante ha sido inscrito correctamente");
            }else{
                System.out.println("Puede que el estudiante no se halla encontrado o que el curso no se halla encontrado (revisa que hallas ingresado bien el codigo) o ");
                System.out.println("El estudiante no cumple con los requisitos");
            }
        }
    }

    /*Elimina una inscripcion que no este activa.
    * */

    public void eliminarInscripcion(){
        String codigo = this.getValidaciones().codigo("ingresa el codigo de la inscripcion: ");
        for(int i = 0; i < this.getInscripcions().size(); i++) {
            if (this.getInscripcions().get(i).getCodigoInscripcion().equalsIgnoreCase(codigo) && this.getInscripcions().get(i).getEstado() != EstadoIncripcion.ACTIVA && this.getInscripcions().get(i)!= null) {
                this.getInscripcions().remove(i);
                System.out.println("La inscripcion ha sido eliminada correctamente.");
            } else {
                System.out.println("La inscripcion no ha sido encontrada, revisa el codigo.");
            }
        }
    }

    /*
    * esta busca la inscripcion.
    * */

    public Inscripcion buscarInscripcion(String codigo){
        Inscripcion inscripcion = null;
        for(int i = 0; i < this.getInscripcions().size(); i++) {
            if (this.getInscripcions().get(i).getCodigoInscripcion().equalsIgnoreCase(codigo) ) {
                inscripcion = this.getInscripcions().get(i);
            }
        }
        return inscripcion;
    }

    //hace como un asesoramiento a ver si el estudiante ceumple con todo y si hay cupos.

    public void validarCuposYRequisitos(GestorEstudiantes gestorEstudiantes,ControlerCursos controlerCursos){
        String codigoProfesor = this.getValidaciones().codigo("ingresa el codigo del estudiante: ");
        Estudiante estudiante = gestorEstudiantes.buscarCodigo(codigoProfesor);
        String codigoCruso = this.getValidaciones().codigo("ingresa el codigo del curso");
        Cursos curso = controlerCursos.buscarCurso(codigoCruso);
        curso.validarRequisitos(estudiante,curso);
        boolean coolean = curso.hayCuposDisponibles();
    }
}
