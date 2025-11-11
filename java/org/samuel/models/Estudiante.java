package org.samuel.models;
import org.samuel.Validador.Carreras;

import java.time.LocalDate;

public class Estudiante {
    private String codigo;
    private String nombres;
    private String apellidos;
    private String email;
    private LocalDate fechaNacimiento;
    private Carreras carrera;
    private double promedioAcumulado;
    private int semestreActual;

    public Estudiante(String codigo, Carreras carrera, int semestreActual, String email, LocalDate fechaNacimiento, String apellidos, String nombres) {
        this.codigo = codigo;
        this.carrera = carrera;
        this.promedioAcumulado = promedioAcumulado;
        this.semestreActual = semestreActual;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.apellidos = apellidos;
        this.nombres = nombres;
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

    public String getEmail() {
        return email;
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

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public void informacion() {
        System.out.println("==========Information de estudiante=============");
        System.out.println("nombre del estudiante: " + this.getNombres());
        System.out.println("apellidos de estudiantes: " + this.getApellidos());
        System.out.println("código del estudiante: " + this.getCodigo());
        System.out.println("estudia la carrera  : "  + this.getCarrera());
        System.out.println("su promedio es : "  + this.getPromedioAcumulado());
        System.out.println("En este momento esta en semestre"  + this.getSemestreActual());
    }
}
