package org.samuel.models;
import org.samuel.Validador.Carreras;

import java.time.LocalDate;

public class Estudiante extends  Persona{
    private LocalDate fechaNacimiento;
    private Carreras carrera;
    private double promedioAcumulado;
    private int semestreActual;

    public Estudiante(String codigo, Carreras carrera, int semestreActual, String email, LocalDate fechaNacimiento, String apellidos, String nombres) {
        super(nombres,apellidos,email,codigo);
        this.carrera = carrera;
        this.promedioAcumulado = promedioAcumulado;
        this.semestreActual = semestreActual;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Carreras getCarrera() {
        return carrera;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public double getPromedioAcumulado() {
        return promedioAcumulado;
    }

    public int getSemestreActual() {
        return semestreActual;
    }

    public void setCarrera(Carreras carrera) {
        this.carrera = carrera;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setSemestreActual(int semestreActual) {
        this.semestreActual = semestreActual;
    }

    public void setPromedioAcumulado(double promedioAcumulado) {
        this.promedioAcumulado = promedioAcumulado;
    }

    //Este metodo muestra la informacion del estuadiante que selecciones con el controler

    public void informacion() {
        System.out.println("==========Information de estudiante=============");
        System.out.println("nombre del estudiante: " + this.getNombre());
        System.out.println("apellidos de estudiantes: " + this.getApellidos());
        System.out.println("código del estudiante: " + this.getCodigo());
        System.out.println("estudia la carrera  : "  + this.getCarrera());
        System.out.println("su promedio es : "  + this.getPromedioAcumulado());
        System.out.println("En este momento esta en semestre"  + this.getSemestreActual());
    }
}
