package org.samuel.Controlers;

import org.samuel.Validador.Carreras;
import org.samuel.Validador.Validaciones;
import org.samuel.models.Estudiante;

import java.time.LocalDate;
import java.util.ArrayList;

public class GestorEstudiantes {

    private ArrayList<Estudiante> listaEstudiantes;
    private Validaciones validaciones;

    public GestorEstudiantes() {
        this.listaEstudiantes = new ArrayList<>();
        this.validaciones = new Validaciones();
    }

    public ArrayList<Estudiante> getListaEstudiantes() {
        return listaEstudiantes;
    }

    public void setListaEstudiantes(Estudiante datos, int indice) {
        this.listaEstudiantes.set(indice,datos);
    }
    public void agregarEstudiante(Estudiante estudiante){
        this.listaEstudiantes.add(estudiante);
    }

    public void setListaEstudiantes(ArrayList<Estudiante> listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }

    public void setValidaciones(Validaciones validaciones) {
        this.validaciones = validaciones;
    }

    public Validaciones getValidaciones() {
        return validaciones;
    }

    //Busca estudiantes por codigo en la lista de estudiantes

    public Estudiante buscarCodigo(String codigo) {
        Estudiante estudiante = null;
        boolean validador = true;
        while(validador){
            for (int i = 0; i < this.getListaEstudiantes().size(); i++){
                if (this.getListaEstudiantes().get(i).getCodigo().equalsIgnoreCase(codigo)) {
                    System.out.println("estudiante encontrado: ");
                    estudiante = this.getListaEstudiantes().get(i);
                }
            }
            if(estudiante == null ){
                System.out.println("Estudiante no encontrado encontrado: ");
                return estudiante;
            }else{
                System.out.println("Estudiante encontrado:");
                return estudiante;
            }
        }
        return estudiante;
    }

    //Realiza una lista de estudiantes con la misma carrera.

    public ArrayList<Estudiante> buscarPorCarrera(){
        ArrayList<Estudiante> estudiante = null;
        Carreras carreras = this.getValidaciones().ingresarCarrera();
        for (int i = 0; i < this.getListaEstudiantes().size(); i++) {
            if (this.getListaEstudiantes().get(i).getCarrera() == carreras) {
                estudiante.add((this.getListaEstudiantes().get(i)));
            }
        }
        if (estudiante ==  null){
            System.out.println("No se han encontrado estudiantes en esa carrera");
            return estudiante;
        }else{
            System.out.println("Estos son los estudiantes que se han encontrado: ");
            return estudiante;
        }
    }

    //muestra la lista de los estudiantes con la misma carrera o la lista que se ingrese

    public void mostrarEstudiantesListados(ArrayList<Estudiante> listado){
        Carreras carreras = this.getValidaciones().ingresarCarrera();
        System.out.println("--------Estudiantes registrados en la carrera "+ carreras + "---------");
        for(int i = 0 ; i < listado.size(); i++){
            listado.get(i).informacion();
        }
    }

    // actual la informacion de un estudiante

    public void actualizarEstudiantes(String codigo){
        boolean validador = false;
        for(int i = 0; i < this.getListaEstudiantes().size(); i++){
            if(this.getListaEstudiantes().get(i).getCodigo().equalsIgnoreCase(codigo)){
                Carreras carrera = this.getValidaciones().ingresarCarrera();
                int semestre =  this.getValidaciones().rango(1,11,"ingresa el semestre del " + i + " estudiante: " );
                String email =  this.getValidaciones().email("Ingresa el email del " + i + " estudiante: ");
                this.getListaEstudiantes().get(i).setCarrera(carrera);
                this.getListaEstudiantes().get(i).setEmail(email);
                this.getListaEstudiantes().get(i).setSemestreActual(semestre);
                validador = true;
            }else if(getListaEstudiantes() == null || getListaEstudiantes().size() == 0){
                validador = false;
            }
        }
        if(validador == false){
            System.out.println("No se ha echo el cambio porue no se ha encontrado el estudiantes.");
        }else{
            System.out.println("Se ha hecho el cambio exitosamente.");
        }
    }

    //Este no se uso pero era para mostrar todos estudiantes de la lista por si un recuento.

    public void mostrarEtudiantes(){
        for (int i = 0; i< this.getListaEstudiantes().size(); i++) {
            this.getListaEstudiantes().get(i).informacion();
        }
    }
}
