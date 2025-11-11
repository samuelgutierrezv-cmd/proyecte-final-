package org.samuel.models;
import  java.util.ArrayList;

public class Profesor {
    private String codigo;
    private String nombres;
    private String apellidos;
    private String especialidad;
    private String email;
    private ArrayList<Cursos> cursosAsignados;

    public Profesor(String codigo, String nombres, String apellidos, String email, String especialidad) {
        this.codigo = codigo;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.email = email;
        this.especialidad = especialidad;
        this.cursosAsignados = new ArrayList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<Cursos> getCursosAsignados() {
        return cursosAsignados;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public void setCursosAsignados(ArrayList<Cursos> cursosAsignados) {
        this.cursosAsignados = cursosAsignados;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void asignarCurso(Cursos curso){
        if(this.getCursosAsignados().size() <= 7){
            this.getCursosAsignados().add(curso);
        }else{
           System.out.println("no se puede ingresar curso limite de cursos. ");
        }
    }

    public int obtenerCargaAcadamica(){
        int contador = 0;
        for(int i = 0 ; i < this.getCursosAsignados().size();i++){
            contador += this.getCursosAsignados().get(i).getNumeroHorasSemestre();
        }
        return contador;
    }

    public void desasignarCurso(String curso) {
        int contador = 0;
        while (contador < this.getCursosAsignados().size()) {
            if (this.getCursosAsignados().get(contador).getNombre() == curso) {
                this.getCursosAsignados().remove(contador);
            } else {
                System.out.println("no se puede ingresar curso limite de cursos. ");
            }
            contador++;
        }
    }
}
