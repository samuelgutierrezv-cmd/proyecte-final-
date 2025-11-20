package org.samuel.models;

public class Persona {
    private String nombre;
    private String email;
    private String apellidos;
    private String codigo;

    public Persona(String nombre, String apellidos, String email, String codigo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
