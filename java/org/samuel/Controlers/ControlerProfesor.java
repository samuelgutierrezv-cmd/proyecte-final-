package org.samuel.Controlers;

import org.samuel.Validador.Validaciones;
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
    public void mostrarCargaAcademica(){
        String profesor = this.getValidar().codigo("ingrese el codigo del profesor: ");
        for(int i = 0; i < this.getProfesores().size(); i++){
            if(this.getProfesores().get(i).getCodigo().equalsIgnoreCase(profesor)) {

                System.out.println("carga academica profesor "+ this.getProfesores().get(i).getNombres() + "es de "+ this.getProfesores().get(i).obtenerCargaAcadamica()+ " horas ");
            }else{
                System.out.println("EL profesor no ha sido encontrado revisa el codigo.");
            }
        }
    }

}
