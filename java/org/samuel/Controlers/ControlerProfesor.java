package org.samuel.Controlers;

import org.samuel.Validador.Validaciones;
import org.samuel.models.Cursos;
import org.samuel.models.Estudiante;
import org.samuel.models.Profesor;

import java.util.ArrayList;

public class ControlerProfesor {
    private ArrayList<Profesor> profesores;
    private Validaciones validar;

    public ControlerProfesor() {
        this.profesores = new ArrayList<>();
        this.validar = new Validaciones();
    }

    public ArrayList<Profesor> getProfesores() {
        return profesores;
    }

    public Validaciones getValidar() {
        return validar;
    }

    public Validaciones getValidaciones() {
        return this.validar;
    }

    //este hace lo mismo que lo de estudiantes crea el profesor y lo agrega.

    public void crearProfesores(int numero){
        for(int i = 1; i <= numero; i++){
            String nombre =  this.getValidar().validarTexto("ingresar nombre del " + i + " profesor: ");
            String apellidos = this.getValidar().validarTexto("Ingresa los apellidos del "+ i + " profesor: ");
            String codigo  = this.getValidar().codigo("ingresa el codigo del " + i + " profesor (no olvides su codigo): ");
            String email =  this.getValidar().email("igresa el email del "+ i + " profesor: ");
            String especialidad =  this.getValidar().validarTexto("ingresa la especialidad del profesor: ");
            Profesor profe = new Profesor(codigo,nombre,apellidos,email,especialidad);
        }
        System.out.println("Recuerda agregarle un curso a cada profesro: ");
    }

    //este simplemente busca el profesor y llama a su metodo mostrar carga academic

    public void mostrarCargaAcademica(){
        String profesor = this.getValidar().codigo("ingrese el codigo del profesor: ");
        System.out.println(this.buscarCodigo(profesor).obtenerCargaAcadamica());
    }

    //Busca el profesor en la lista por el codigo

    public Profesor buscarCodigo(String codigo) {
        Profesor estudiante = null;
        boolean validador = true;
        while(validador){
            for (int i = 0; i < this.getProfesores().size(); i++){
                if (this.getProfesores().get(i).getCodigo().equalsIgnoreCase(codigo)) {
                    System.out.println("Profesor encintrado: ");
                    estudiante = this.getProfesores().get(i);
                }
            }
            if(estudiante == null ){
                System.out.println("Estudiante no encontrado encontrado: ");
            }else{
                return estudiante;
            }
        }
        return estudiante;
    }

    //Este metodo ingresa al profesor a un curso primero validando que el curso no este con profesor
    // o que el profesor ya tenga ese curso*/

    public void ingresarACurso(ControlerCursos curosss){
        String codigo = this.getValidaciones().codigo("ingresa el codigo del profesor: ");
        String codigoCurso= this.getValidaciones().codigo("ingresa el codigo del curso que quieres agregar: ");
        if(curosss.buscarCurso(codigoCurso).getCodigoProfesor() == null && curosss.buscarCurso(codigoCurso) != null &&this.buscarCodigo(codigo) == null && this.buscarCodigo(codigo) != null){
            if(curosss.buscarCurso(codigoCurso).getCodigoProfesor() == null) {
                System.out.println("puede que el profesor no se halla encontrado escribiste mal el codigo  o");
                System.out.println("NO se puede ingresar profesor porque ya tiene un profesor o el curso no existe.");
                curosss.buscarCurso(codigoCurso).setCodigoProfesor(this.buscarCodigo(codigo));
                System.out.println("Profesor ingresado exitosamente.");
            }else{
                System.out.println("El curso ya tiene profesor");
            }
        }else{
            System.out.println("puede que el profesor no se halla encontrado escribiste mal el codigo  o");
            System.out.println("NO se puede ingresar profesor porque ya tiene un profesor o el curso no existe.");
        }
    }

    public void elminarProfesor(){
        String codigo = this.getValidaciones().codigo("ingresa el codigo del profesor: ");
        boolean validador = false;
        for (int i = 0; i< this.getProfesores().size(); i++) {
            if(this.getProfesores().get(i).getCodigo() == codigo){
                if(this.getProfesores().get(i).getCursosAsignados().size() <=0){
                    this.getProfesores().remove(i);
                    validador = true;
                }
            }
        }
        if(validador = false){
            System.out.println("no se encontró el estudiantes no se ha podido eliminar.");
        }else{
            System.out.println("Se ha hecho el cambio exitosamente.");
        }
    }

    //metodo para validar que un profesor no tengo ese curso ya asignado

    public boolean buscarCursoProfesor(String codigoCurso,String codigoProfesor){
        boolean validador = false;
        for(int i = 0; this.getProfesores().size() > i; i++){
            Profesor  profesor = this.getProfesores().get(i);
            if(profesor.getCodigo().equals(codigoProfesor)){
                for(int j= 0  ;  j <profesor.getCursosAsignados().size() ; j++){
                    if(profesor.getCursosAsignados().get(j).getCodigo().equals(codigoCurso)){
                        validador = true;
                    }
                }
            }
        }
        return validador;
    }

}
