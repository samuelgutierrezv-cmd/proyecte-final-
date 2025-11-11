package org.samuel.Controlers;

import org.samuel.Validador.Carreras;
import org.samuel.Validador.Validaciones;
import org.samuel.models.Estudiante;

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

    public Estudiante buscarCodigo(String codigo) {
        Estudiante estudiante = null;
        boolean validador = true;
        while(validador){
            codigo = this.getValidaciones().codigo("ingresa el codigo de nuevo: ");
            for (int i = 0; i < this.getListaEstudiantes().size(); i++){
                if (this.getListaEstudiantes().get(i).getCodigo().equalsIgnoreCase(codigo)) {
                    System.out.println("estudiante encontrado: ");
                    estudiante = this.getListaEstudiantes().get(i);
                }
            }
            if(estudiante == null ){
                System.out.println("Estudiante no encontrado encontrado: ");
            }else{
                System.out.println("Estudiante encontrado:");
                return estudiante;
            }
        }
        return estudiante;
    }
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
    public void mostrarEtudiantesListados(ArrayList<Estudiante> listado){
        Carreras carreras = this.getValidaciones().ingresarCarrera();
        System.out.println("--------Estudiantes registrados en la carrera "+ carreras + "---------");
        for(int i = 0 ; i < listado.size(); i++){
            System.out.println(listado.get(i).getNombres());
            System.out.println(listado.get(i).getCodigo());
            System.out.println(listado.get(i).getCarrera());
        }
    }
    public boolean actulizarEstudiantes(String codigo, Estudiante datos){
        boolean validador = false;
        for(int i = 0; i < this.getListaEstudiantes().size(); i++){
            if(this.getListaEstudiantes().get(i).getCodigo().equalsIgnoreCase(codigo)){
                this.setListaEstudiantes(datos,i);
                validador = true;
            }
        }
        if(validador = false){
            System.out.println("lo se ha hecho el cambio porue no se ha encontrado el estudiantes.");
            return validador;
        }else{
            System.out.println("Se ha hecho el cambio exitosamente.");
            return validador;
        }
    }
    public boolean eliminarEtudiante(String codigo){
        boolean validador = false;
        for (int i = 0; i< this.getListaEstudiantes().size(); i++) {
            if(this.getListaEstudiantes().get(i).getCodigo() == codigo){
                this.getListaEstudiantes().remove(i);
                validador = true;
            }
        }
        if(validador = false){
            System.out.println("no se encontró el estudiantes no se ha podido eliminar.");
            return  validador;
        }else{
            System.out.println("Se ha hecho el cambio exitosamente.");
            return validador;
        }
    }
    public void mostrarEtudiantes(){
        for (int i = 0; i< this.getListaEstudiantes().size(); i++) {
            this.getListaEstudiantes().get(i).informacion();
        }
    }
}
