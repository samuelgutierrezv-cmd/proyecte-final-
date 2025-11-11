package org.samuel.models;
import org.samuel.Validador.EstadoIncripcion;

import java.time.LocalDate;

public class Inscripcion {
    private String codigoEstudiante;
    private String codigoCurso;
    private LocalDate fechaInscripcion;
    private EstadoIncripcion estado;

    public Inscripcion(String codigoEstudiante, LocalDate fechaInscripcion, EstadoIncripcion estado, String codigoCurso) {
        this.codigoEstudiante = codigoEstudiante;
        this.fechaInscripcion = fechaInscripcion;
        this.estado = estado;
        this.codigoCurso = codigoCurso;
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
}
