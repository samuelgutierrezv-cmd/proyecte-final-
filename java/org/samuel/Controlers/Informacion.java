package org.samuel.Controlers;

import org.samuel.models.*;

import java.util.ArrayList;

public class Informacion {

    public void profesoresMayorCarga(ControlerProfesor controlerProfesor){
        int contador = 0;
        ArrayList<Profesor> profesors =  controlerProfesor.getProfesores();
        for (Profesor profesor : profesors) {
            boolean esMayor = profesor.obtenerCargaAcadamica() >= 6;
            if (esMayor){
                profesor.mostrarInformacion();
                contador++;
            }
        }
        if(contador ==  0) {
            System.out.println("No se han escontrado profesores con cargas academiacas altas ");
        }
    }

    public void cursosMayorDemanda(ControlerCursos cursos){
        ArrayList<Cursos> curso = cursos.getCursos();
        for(int i = 0; curso.size() > i; i++){
            Cursos  c = curso.get(i);
            if(c.getNumeroInscripciones() > 48){
                System.out.println("Nombre del curso :" +curso.get(i).getNombre());
                System.out.println("Codigo del profesor: " + curso.get(i).getCodigoProfesor());
                System.out.println("Horario del curso: " + curso.get(i).getHorario());
            }
        }
    }

}
