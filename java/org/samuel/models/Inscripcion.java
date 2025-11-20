package org.samuel.models;
import org.samuel.Validador.EstadoIncripcion;

import java.time.LocalDate;

public class Inscripcion {
    private String codigoEstudiante;
    private String codigoCurso;
    private String codigoInscripcion;
    private LocalDate fechaInscripcion;
    private EstadoIncripcion estado;
    private Calificaciones calificaciones;

    public Inscripcion(String codigoEstudiante, LocalDate fechaInscripcion, EstadoIncripcion estado, String codigoCurso, String codigoInscripcion) {
        this.codigoEstudiante = codigoEstudiante;
        this.fechaInscripcion = fechaInscripcion;
        this.estado = estado;
        this.codigoCurso = codigoCurso;
        this.codigoInscripcion = codigoInscripcion;
        this.calificaciones = new Calificaciones(codigoInscripcion);
    }

    public String getCodigoEstudiante() {
        return codigoEstudiante;
    }

    public String getCodigoCurso() {
        return codigoCurso;
    }

    public EstadoIncripcion getEstado() {
        return estado;
    }

    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setCodigoEstudiante(String codigoEstudiante) {
        this.codigoEstudiante = codigoEstudiante;
    }

    public void setEstado(EstadoIncripcion estado) {
        this.estado = estado;
    }

    public void setCodigoCurso(String codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public void setFechaInscripcion(LocalDate fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public String getCodigoInscripcion() {
        return codigoInscripcion;
    }

    public void setCodigoInscripcion(String codigoInscripcion) {
        this.codigoInscripcion = codigoInscripcion;
    }



    public Calificaciones getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(Calificaciones calificaciones) {
        this.calificaciones = calificaciones;
    }
}
