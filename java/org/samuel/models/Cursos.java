package org.samuel.models;
import org.samuel.Validador.Carreras;

import  java.util.ArrayList;

public class Cursos {
    private String codigo;
    private String nombre;
    private int creditos;
    private int cupoMaximo;
    private Profesor codigoProfesor;
    private String[] horario;
    private int numeroInscripciones;
    private int numeroHorasSemestre;
    private int salon;
    private double promedioRequisito;
    private int semestreRequisito;
    private Carreras carreraRequisito;
    private ArrayList<Estudiante> estudiantesInscritos;

    public Cursos(String codigo, String nombre, int creditos, int numeroHorasSemestre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = creditos;
        this.numeroHorasSemestre = numeroHorasSemestre;
        this.numeroInscripciones = 0;
        this.cupoMaximo = 0;
        this.semestreRequisito = 0;
        this.promedioRequisito= 0;
        this.salon = 0;
        this.horario = new String[5];
        this.carreraRequisito = null;
        this.estudiantesInscritos = new ArrayList<>();
        this.codigoProfesor = null;
    }

    public void setNumeroHorasSemestre(int numeroHorasSemestre) {
        this.numeroHorasSemestre = numeroHorasSemestre;
    }

    public int getNumeroHorasSemestre() {
        return numeroHorasSemestre;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public int getCupoMaximo() {
        return cupoMaximo;
    }

    public Profesor getCodigoProfesor() {
        return codigoProfesor;
    }

    public String[] getHorario() {
        return horario;
    }

    public int getSalon() {
        return salon;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public void setCodigoProfesor(Profesor codigoProfesor) {
        this.codigoProfesor = codigoProfesor;
    }

    public void setCupoMaximo(int cupoMaximo) {
        this.cupoMaximo = cupoMaximo;
    }


    public void setHorario(String[] horario) {
        this.horario = horario;
    }

    public int getNumeroInscripciones() {
        return numeroInscripciones;
    }

    public void setPromedioRequisito(double promedioRequisito) {
        this.promedioRequisito = promedioRequisito;
    }

    public void setCarreraRequisito(Carreras carreraRequisito) {
        this.carreraRequisito = carreraRequisito;
    }

    public void setEstudiantesInscritos(ArrayList<Estudiante> estudiantesInscritos) {
        this.estudiantesInscritos = estudiantesInscritos;
    }

    public void setSemestreRequisito(int semestreRequisito) {
        this.semestreRequisito = semestreRequisito;
    }

    public ArrayList<Estudiante> getEstudiantesInscritos() {
        return estudiantesInscritos;
    }

    public Carreras getCarreraRequisito() {
        return carreraRequisito;
    }

    public int getSemestreRequisito() {
        return semestreRequisito;
    }

    public double getPromedioRequisito() {
        return promedioRequisito;
    }

    public void setNumeroInscripciones(int numeroInscripciones) {
        this.numeroInscripciones = numeroInscripciones;
    }

    public void addEstudiante(Estudiante estudiante){
        this.estudiantesInscritos.add(estudiante);
    }
    public void setSalon(int salon) {
        this.salon = salon;
    }

    // suelta true o false si el curso tiene cupos disponibles

    public boolean hayCuposDisponibles(){
        if(this.getCupoMaximo() == this.getNumeroInscripciones()){
            System.out.println("No hay cipos disponibles no puedes ingresar estudiante.");
            return false;
        }else{
            System.out.println("Si hay cupos disponibles.");
            return true;
        }
    }

    //Este hace lo mismo pero con los requisitos

    public boolean validarRequisitos(Estudiante estudiante, Cursos curso){
        if(estudiante.getCarrera() == curso.getCarreraRequisito() &&
           estudiante.getSemestreActual() == curso.getSemestreRequisito() &&
           estudiante.getPromedioAcumulado() >= curso.getPromedioRequisito()){
            return true;
        }else {
            return false;
        }
    }
}
