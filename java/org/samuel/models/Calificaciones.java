package org.samuel.models;

import org.samuel.Controlers.ControlerCursos;
import org.samuel.Controlers.ControlerInscripciones;
import org.samuel.Controlers.ControlerProfesor;
import org.samuel.Validador.EstadoCalificaiones;
import org.samuel.Validador.EstadoIncripcion;
import org.samuel.Validador.Validaciones;

public class Calificaciones {
    private String codigoInscripcion;
    private double[] notas= {0.0,0.0,0.0};
    private double notaFinal;
    private double promedioFinal;
    private EstadoCalificaiones estado;

    public Calificaciones(String codigoInscripcion) {
        this.codigoInscripcion = codigoInscripcion;
        this.notaFinal = 0.0;
        this.promedioFinal = 0.0;
    }

    public String getCodigoInscripcion() {
        return codigoInscripcion;
    }

    public double getNotaFinal() {
        return notaFinal;
    }

    public double getPromedioFinal() {
        return promedioFinal;
    }

    public EstadoCalificaiones getEstado() {
        return estado;
    }

    public void setCodigoInscripcion(String codigoInscripcion) {
        this.codigoInscripcion = codigoInscripcion;
    }

    public void setNotaFinal(double notaFinal) {
        this.notaFinal = notaFinal;
    }

    public void setPromedioFinal(double promedioFinal) {
        this.promedioFinal = promedioFinal;
    }

    public void setEstado(EstadoCalificaiones estado) {
        this.estado = estado;
    }

    // verificar si se pueden ingresar la nota final si las demas notas ya estan ingresadas
    public boolean  ingresarNotaFinal(Calificaciones calificaciones){
        if (calificaciones.getNotas()[0] == 0.0 || calificaciones.getNotas()[1] == 0.0 || calificaciones.getNotas()[2] == 0.0) {
            System.out.println("No se puede ingresar la nota final, faltan notas por ingresar.");
            return false;
        }else {
            System.out.println("Puedes ingresar la nota final.");
            return true;
        }
    }

    // calcular el promedio final
    public double calcularPromedioFinal(){
        double suma = 0.0;
        for(int i = 0; i < this.getNotas().length; i++){
            suma += this.getNotas()[i];
        }
        double promedio = (suma+ this.getNotaFinal())/ (this.getNotas().length + 1) ;
        this.setPromedioFinal(promedio);
        return promedio;
    }

    public double[] getNotas() {
        return notas;
    }


    public void setNotas(double[] notas) {
        this.notas = notas;
    }

    // calcular el estado de las calificaciones

    public EstadoCalificaiones calcularEstado(){
        if(this.getPromedioFinal() < 3.0){
            System.out.println("el estudiante esta reprobado.");
            return EstadoCalificaiones.REPROBADO;
        }else {
            System.out.println("El estudiante paso la nota. ");
            return EstadoCalificaiones.APROBADO;
        }
    }

    /* verificar si se puede evaluar la inscripcion o las notas del estusiante en el curso
    * como se quiera ver
    * */
    public boolean sePuedEvaluar(ControlerInscripciones controlerInscripciones, ControlerCursos controlerCursos){
        Validaciones validaciones = new Validaciones();
        String codigo = validaciones.codigo("ingresa el codigo de la inscripcion: ");
        Inscripcion inscripcion = controlerInscripciones.buscarInscripcion(codigo);
        Cursos curso = controlerCursos.buscarCurso(inscripcion.getCodigoCurso());
        if(inscripcion.getEstado() == EstadoIncripcion.ACTIVA|| curso.getCodigoProfesor() != null){
            return true;
        }else{
            return false;
        }
    }

    // verificar si la nota anterior ya fue ingresada

    public boolean ingresadas (int numero ){
        if(this.getNotas()[numero-2] == 0.0) {
            return  false;
        }else if((numero-2) == -1){
            return true;
        }else{
            return true;
        }
    }
}
