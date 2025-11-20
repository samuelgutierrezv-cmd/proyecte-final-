package org.samuel.Controlers;

import org.samuel.Validador.EstadoIncripcion;
import org.samuel.Validador.Validaciones;
import org.samuel.models.Calificaciones;

public class ControlerCalificaciones {
    private Validaciones validaciones;

    public ControlerCalificaciones(){
        this.validaciones = new Validaciones();
    }

    public Validaciones getValidaciones() {
        return validaciones;
    }

    //Este metodo ingresa las notas y las agrega a calificaciones en la inscripcion.
    // pero las valida en orden osea las tienen que meter en orden primero la 1 segundo la 2
    // y tercero la  3
    // */

    public void ingresarNota(ControlerInscripciones controlerInscripciones, ControlerCursos controlerCursos){
        String codigo = this.getValidaciones().codigo("ingresa el codigo de la inscripcion: ");
        Calificaciones calificaciones = controlerInscripciones.buscarInscripcion(codigo).getCalificaciones();
        int nota = this.validaciones.rango(1,3,"ingresa la nota que quieres ingress la 1 la 2 o la 3 ingresa el numero de la nota: ");
        for(int i = 0 ;i < controlerInscripciones.buscarInscripcion(codigo).getCalificaciones().getNotas().length; i++){
            if(i == (nota -1) && calificaciones.getNotas()[i] == 0.0 && calificaciones.sePuedEvaluar(controlerInscripciones,controlerCursos)){

                if(calificaciones.ingresadas(nota)){
                    double notaIngresada = validaciones.rangoDecimal(0.1,5.0,"ingresa la nota entre 0.1 y 5.0: ");
                    controlerInscripciones.buscarInscripcion(codigo).getCalificaciones().getNotas()[i] = notaIngresada;
                }else{
                    System.out.println("No has ingression la nota anterior a esta.");
                }
            }else{
                System.out.println("El cursor esta sin professor");
            }
        }
    }

    /*este metodo ingresa la nota final del curso pero si las demas ya se han ingresado
    * tambien establece la inscripcion como completada ya que como se ingresaron todas las notas
    * significa que el curso acabo.
    * */

    public void ingresarNotaFinal(ControlerInscripciones controlerInscripciones){
        String codigo = this.getValidaciones().codigo("ingresa el codigo de la inscripcion: ");
        Calificaciones calificaciones = controlerInscripciones.buscarInscripcion(codigo).getCalificaciones();
        if(calificaciones.ingresarNotaFinal(calificaciones)){
            double notaFinal = this.getValidaciones().rangoDecimal(0.1,5.0,"ingresa la nota final entre 0.1 y 5.0: ");
            controlerInscripciones.buscarInscripcion(codigo).getCalificaciones().setNotaFinal(notaFinal);
            double promedioFinal = calificaciones.calcularPromedioFinal();
            controlerInscripciones.buscarInscripcion(codigo).getCalificaciones().setPromedioFinal(promedioFinal);
            controlerInscripciones.buscarInscripcion(codigo).getCalificaciones().setEstado(calificaciones.calcularEstado());
            controlerInscripciones.buscarInscripcion(codigo).setEstado(EstadoIncripcion.COMPLETADA);
        }
    }

    //aqui valida si se puede mostrar el porcentaje y lo muestra usando el metodo de
    // Calificacion.
    // */

    public void mostrarPorcentajeCurso(ControlerInscripciones controlerInscripciones){
        String  codigo = this.getValidaciones().codigo("ingresa el codigo de la inscripcion: ");
        if(controlerInscripciones.buscarInscripcion(codigo).getCalificaciones().getNotas()[0] == 0.0 || controlerInscripciones.buscarInscripcion(codigo).getCalificaciones().getNotas()[2] == 0.0 || controlerInscripciones.buscarInscripcion(codigo).getCalificaciones().getNotas()[1] == 0.0){
            double promedio = controlerInscripciones.buscarInscripcion(codigo).getCalificaciones().calcularPromedioFinal();
            controlerInscripciones.buscarInscripcion(codigo).getCalificaciones().setPromedioFinal(promedio);
            System.out.println("El promedio del curso es "+  promedio +  " de sin algunas notas o solo una: ");
        }else if(controlerInscripciones.buscarInscripcion(codigo).getCalificaciones().getNotaFinal() == 0.0){
            double promedio = controlerInscripciones.buscarInscripcion(codigo).getCalificaciones().calcularPromedioFinal();
            controlerInscripciones.buscarInscripcion(codigo).getCalificaciones().setPromedioFinal(promedio);
            System.out.println("El promedio del curso es de " + promedio + "sin la nota final");
        }
    }

    /*Este actualiza el estado del curso reprobado o pasado del curso o de la calificaion no de
    * la inscripcion.
    * */
    public void estadoCurso(ControlerInscripciones controlerInscripciones){
        String  codigo = this.getValidaciones().codigo("ingresa el codigo de la inscripcion: ");
        if(controlerInscripciones.buscarInscripcion(codigo).getCalificaciones().getPromedioFinal() != 0.0){
            controlerInscripciones.buscarInscripcion(codigo).getCalificaciones().setEstado(controlerInscripciones.buscarInscripcion(codigo).getCalificaciones().calcularEstado());
            System.out.println("El estado del curso es: "+ controlerInscripciones.buscarInscripcion(codigo).getCalificaciones().calcularEstado());
        }else if(controlerInscripciones.buscarInscripcion(codigo).getCalificaciones().getPromedioFinal() == 0.0) {
            System.out.println("Todavia no esta definida el promedio final.");
        }
    }
}
