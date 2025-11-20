package org.samuel.models;
import  java.util.ArrayList;

public class Profesor  extends  Persona{
    private String especialidad;
    private ArrayList<Cursos> cursosAsignados;

    public Profesor(String codigo, String nombres, String apellidos, String email, String especialidad) {
        super(nombres,apellidos,email,codigo);
        this.especialidad = especialidad;
        this.cursosAsignados = new ArrayList<>();
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public ArrayList<Cursos> getCursosAsignados() {
        return cursosAsignados;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public void setCursosAsignados(ArrayList<Cursos> cursosAsignados) {
        this.cursosAsignados = cursosAsignados;
    }

    public boolean puedeaAsignarCurso(){
        if(this.getCursosAsignados().size() < 7){
            return true;
        }else{
           return false;
        }
    }

    public void mostrarInformacion(){
        System.out.println("----------------Informacion---------------");
        System.out.println("Nombre profe: " + this.getNombre());
        System.out.println("Apellido profe: " + this.getApellidos());
        System.out.println("Codigo de profe: " + this.getCodigo());
        System.out.println("Especialidad: " + this.getEspecialidad());
    }

    public int obtenerCargaAcadamica(){
        int contador = 0;
        for(int i = 0 ; i < this.getCursosAsignados().size();i++){
            contador += this.getCursosAsignados().get(i).getNumeroHorasSemestre();
        }
        return contador;
    }
}
