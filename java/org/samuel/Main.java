package org.samuel;

import org.samuel.Controlers.*;
import org.samuel.Views.Vistas;
import org.samuel.Validador.*;
import org.samuel.models.Estudiante;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Validaciones validar =  new Validaciones();
        Vistas vista = new Vistas();
        boolean valid= true;
        ControlerCursos controler = new ControlerCursos();
        ControlerEstudiantes controlerEstudiantes = new ControlerEstudiantes();
        ControlerInscripciones controlerInscripciones = new ControlerInscripciones();
        ControlerCalificaciones controlerCalificaciones = new ControlerCalificaciones();
        GestorEstudiantes gestorEstudiantes = new GestorEstudiantes();
        ControlerProfesor controlerProfesores = new ControlerProfesor();
        ControlerCursos controlerCursos = new ControlerCursos();
        Informacion informacion = new Informacion();
        while(valid){
            vista.principal();
            int operacion = validar.rango(1,7,"ingresa la gestion que quieres realizar: ");
            int operacio = 0;
            switch (operacion) {
                case 1:
                    vista.gestionDeEstudiantes();
                    operacio = validar.rango(1, 5, "ingresa la gestion que quieres realizar: ");
                    switch (operacio) {
                        case 1:
                            int numeroEstudiantes = validar.rango(1,5,"ingresa el numero de estudiantes que quieres agregar maximo 5:");
                            controlerEstudiantes.crearEstudiantes(numeroEstudiantes);
                            break;
                        case 2:
                            String codigo0 = validar.codigo("Ingresa el codigo del estudiante para buscarlo: ");
                            Estudiante estudiante1 = gestorEstudiantes.buscarCodigo(codigo0);
                            if(estudiante1 == null){
                                System.out.println("estudiante no se a encontrado");
                            }else{
                                estudiante1.informacion();
                            }
                            break;
                        case 3:
                            String codigo= validar.codigo("Ingresa el codigo del estudiante que quieres actualizar informacion: ");
                            gestorEstudiantes.actualizarEstudiantes(codigo);
                            break;
                        case 4:
                            ArrayList<Estudiante> carreras = gestorEstudiantes.buscarPorCarrera();
                            gestorEstudiantes.mostrarEstudiantesListados(carreras);
                            break;
                    }
                    break;
                case 2:
                    vista.gestionDeProfesor();
                    operacio = validar.rango(1,4,"ingresa la gestion que quieres hacer: ");
                    switch (operacio) {
                        case 1:
                            int numero = validar.rango(1,5,"ingrese el numero de profesores que quiere crear: ");
                            controlerProfesores.crearProfesores(numero);
                            break;
                        case 2:
                            controlerProfesores.ingresarACurso(controlerCursos);
                            break;
                        case 3:
                            controlerProfesores.mostrarCargaAcademica();
                            break;
                        case 4:
                            controlerProfesores.elminarProfesor();
                            break;
                    }
                    break;
                case 3:
                    vista.gestionDeCursos();
                    operacio = validar.rango(1,3,"ingresa la gestion que quieres hacer: ");
                    switch (operacio) {
                        case 1:
                            int numeroCursos = validar.rango(1,5,"ingresa el numero de cursos que quieres agregar maximo 5:");
                            controler.crearCursosConInformacionCompleta(numeroCursos);
                            break;
                        case 2:
                            controlerCursos.definirPrerrequisitosCupos();
                            break;
                        case 3:
                            controlerCursos.definirHorarioSalon();
                            break;
                    }
                    break;
                case 4:
                    vista.gestionDeInscripciones();
                    operacio = validar.rango(1,2,"ingresa la gestion que quieres hacer: ");
                    switch (operacio) {
                        case 1:
                            controlerInscripciones.registrarEstudiante(controlerEstudiantes,controlerCursos);
                            break;
                        case 2:
                            controlerInscripciones.validarCuposYRequisitos(gestorEstudiantes,controlerCursos);
                            break;
                    }
                    break;
                case 5:
                    vista.gestionDeCalificaiones();
                    operacio = validar.rango(1,4,"ingresa la gestion que quieres realizar: ");
                    switch (operacio) {
                        case 1:
                            controlerCalificaciones.ingresarNota(controlerInscripciones,controlerCursos);
                            break;
                        case 2:
                            controlerCalificaciones.ingresarNotaFinal(controlerInscripciones);
                            break;
                        case 3:
                            controlerCalificaciones.mostrarPorcentajeCurso(controlerInscripciones);
                            break;
                        case 4:
                            controlerCalificaciones.estadoCurso(controlerInscripciones);
                            break;
                    }
                    break;
                case 6:
                    vista.reportesYConsultas();
                    operacio = validar.rango(1,2,"ingresa la gestion que quieres realizar: ");
                    switch (operacio) {
                        case 1:
                            informacion.profesoresMayorCarga(controlerProfesores);
                            break;
                        case 2:

                            break;
                    }
                    break;
                case 7:
                    valid =  false;
                    break;
            }
        }
    }
}