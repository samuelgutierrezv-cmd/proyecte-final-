package org.samuel.Controlers;

import org.samuel.Validador.Carreras;
import org.samuel.Validador.Validaciones;
import org.samuel.models.Estudiante;

import java.time.LocalDate;
import java.util.ArrayList;

public class ControlerEstudiantes {
    private GestorEstudiantes gestorEstudiantes;
    private Validaciones validaciones;

    public ControlerEstudiantes() {
        this.gestorEstudiantes = new GestorEstudiantes();
        this.validaciones = new Validaciones();
    }

    public void setGestorEstudiantes(GestorEstudiantes gestorEstudiantes) {
        this.gestorEstudiantes = gestorEstudiantes;
    }

    public void setValidaciones(Validaciones validaciones) {
        this.validaciones = validaciones;
    }

    public GestorEstudiantes getGestorEstudiantes() {
        return gestorEstudiantes;
    }

    public Validaciones getValidaciones() {
        return validaciones;
    }
    public void crearEstudiantes(int numero){
        for(int i = 1; i <= numero; i++){
            String nombre  = this.getValidaciones().validarTexto("ingresa el nombre  para el  "+ i + " estudiante: ");
            String apellidos = this.getValidaciones().validarTexto("ingresa los apellidos del  "+  i + " estuadiante: ");
            String codigo = this.getValidaciones().codigo("ingresa un codigo para el " + i + " estudiante: ");
            Carreras carrera = this.getValidaciones().ingresarCarrera();
            int semestre =  this.getValidaciones().rango(1,11,"ingresa el semestre del " + i + " estudiante: " );
            String email =  this.getValidaciones().email("Ingresa el email del " + i + " estudiante: ");
            LocalDate fechaNacimiento =  this.getValidaciones().fecha("ingresa la fecha de nacimiento del " + i + " estudiante: ");
            Estudiante estudiante = new Estudiante(codigo,carrera,semestre,email,fechaNacimiento,apellidos,nombre);
            this.getGestorEstudiantes().getListaEstudiantes().add(estudiante);
            System.out.println("El estudiante se ha guardado correctamente.");
            System.out.println("Recuerda que tienes que guardar el código de cada estudiante.");
        }

    }
}
