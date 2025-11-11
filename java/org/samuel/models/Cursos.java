package org.samuel.models;
import org.samuel.Validador.Carreras;

import  java.util.ArrayList;

public class Cursos {
    private String codigo;
    private String nombre;
    private int creditos;
    private int cupoMaximo;
    private String codigoProfesor;private String horario;
    private int numeroInscripciones;
    private int numeroHorasSemestre;
    private String salon;
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
        this.salon = null;
        this.horario = null;
        this.carreraRequisito = null;
        this.estudiantesInscritos = new ArrayList<>();
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

    public String getCodigoProfesor() {
        return codigoProfesor;
    }

    public String getHorario() {
        return horario;
    }

    public String getSalon() {
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

    public void setCodigoProfesor(String codigoProfesor) {
        this.codigoProfesor = codigoProfesor;
    }

    public void setCupoMaximo(int cupoMaximo) {
        this.cupoMaximo = cupoMaximo;
    }


    public void setHorario(String horario) {
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

    public void setSalon(String salon) {
        this.salon = salon;
    }

    public boolean hayCuposDisponibles(){
        if(this.getCupoMaximo() == this.getNumeroInscripciones()){
            System.out.println("No hay cipos disponibles no puedes ingresar estudiante.");
            return false;
        }else{
            System.out.println("Si hay cupos disponibles.");
            return true;
        }
    }
}
