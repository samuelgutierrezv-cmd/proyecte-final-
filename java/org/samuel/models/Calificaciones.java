package org.samuel.models;

import org.samuel.Validador.EstadoCalificaiones;

public class Calificaciones {
    private String codigoInscripcion;
    private double nota1;
    private double nota2;
    private double notaFinal;
    private double promedioFinal;
    private EstadoCalificaiones estado;

    public Calificaciones(String codigoInscripcion, double nota1, double nota2, double notaFinal, double promedioFinal) {
        this.codigoInscripcion = codigoInscripcion;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.notaFinal = notaFinal;
        this.promedioFinal = promedioFinal;
    }

    public String getCodigoInscripcion() {
        return codigoInscripcion;
    }

    public double getNota1() {
        return nota1;
    }

    public double getNota2() {
        return nota2;
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

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
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

    public void calularPromedioFinal(){
        double promedioFinal = (this.getNota1() * 0.50) + (this.getNota2() * 0.50);
        this.setPromedioFinal(promedioFinal);
    }

    public EstadoCalificaiones calcularEstadoi(){
        if(this.getPromedioFinal() < 3.0){
            System.out.println("el estudiante esta reprobado.");
            return EstadoCalificaiones.REPROBADO;
        }else if(this.getPromedioFinal() >= 3.0){
            System.out.println("El estudiante paso la nota. ");
            return EstadoCalificaiones.APROBADO;
        }else{
            System.out.println("el estudiante esta pendiente por notas.");
            return EstadoCalificaiones.PENDIENTE;
        }
    }
}
