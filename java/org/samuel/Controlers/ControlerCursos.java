package org.samuel.Controlers;

import org.samuel.Validador.Validaciones;
import org.samuel.models.Cursos;
import org.samuel.models.Estudiante;
import org.samuel.models.Profesor;

import java.util.ArrayList;

public class ControlerCursos {
    ArrayList<Cursos> cursos ;
    Validaciones validaciones;

    public ControlerCursos() {
        this.cursos = new ArrayList<>();
        this.validaciones =  new Validaciones();
    }

    public ArrayList<Cursos> getCursos() {
        return cursos;
    }

    public Validaciones getValidaciones() {
        return validaciones;
    }

    //Crea cursos con la informacion sin profesor
    // pero con todo lo demas
    //  ademas las calificaiones no podran ingresarse si el curso no tiene profesor
    //  */

    public void crearCursosConInformacionCompleta(int numero){
        Validaciones validaciones  =  new Validaciones();
        for(int i =  1 ; i<= numero; i++){
            String codigo = validaciones.validarTexto("Ingresa el codigo del curso no lo olvides(guardalo): ");
            String nombre = validaciones.validarTexto("Ingresa el nombre del curso: ");
            int creditos = validaciones.entero("ingresa el numero de creditos del curso: ");
            int horasSemestre = validaciones.rango(1,80,"Ingresa las horas del curso en el semestre: ");
            Cursos cursos = new Cursos(codigo,nombre,creditos,horasSemestre);
            this.getCursos().add(cursos);
            System.out.println("Se agregado el curso pero recuerda que tienes que agregarle los requisitos del curso y los horarios y el salon del curso y acurdate del codigo del curso.");
        }
    }

    //metodo para buscar curso por el codigo este metodo se hubiera podido aplicar polimorfismo
    // con una interface para todas las clases que necesiten buscar por codigo
    //*/

    public  Cursos buscarCurso(String codigo){
        Validaciones validaciones =  new Validaciones();
        Cursos curso = null;
        boolean valid =  true;
        while(valid){
            for(int i =  0 ; i < this.getCursos().size(); i++){
                if(this.getCursos().get(i).getCodigo().equalsIgnoreCase(codigo)){
                    System.out.println("Curso encontrado");
                    curso = this.getCursos().get(i);
                }
            }
        }
        if(curso == null){
            System.out.println("curso no encontrado : ");
        }else{
            valid = false;
        }
        return curso;
    }

    //En este metodo se definen los prerrequisitos del curso.

    public void definirPrerrequisitosCupos(){
        String codigo = this.getValidaciones().codigo("ingresa el codigo del curso: ");
        for(int i =  0; i < this.getCursos().size() ; i++){
            if(this.getCursos().get(i).getCodigo().equalsIgnoreCase(codigo)){
                System.out.println("monbre del curso encontado: " + this.getCursos().get(i).getNombre());
                this.getCursos().get(i).setCupoMaximo(this.getValidaciones().rango(1,50,"ingress el numero maximo de cupos que debe tener este curso:"));
                this.getCursos().get(i).setCarreraRequisito(this.getValidaciones().ingresarCarrera());
                this.getCursos().get(i).setSemestreRequisito(this.getValidaciones().rango(1,11,"ingrese el semestre que debe cursor el estudiante para poder cursarlo: "));
                this.getCursos().get(i).setPromedioRequisito(this.getValidaciones().rango(1,5,"ingrese el prompted minimo que debe tener el estudiante: "));
            }
        }
    }

    /*este es el metodo que le assigna el curso a el profesor
    * valida si el profesor ya tiene este curos o si otro
    * profesor ya lo tiene
    * */

    public void agregarProfesor(ControlerProfesor controlerProfesor){
        Validaciones validaciones =  new Validaciones();
        String codigo = validaciones.codigo("ingresa el codigo del profesor a asignar curso: ");
        String codigoCurso = validaciones.codigo("ingresa el codigo del curso");

        if(this.buscarCurso(codigoCurso).getCodigoProfesor() == null && controlerProfesor.buscarCursoProfesor(codigoCurso,codigo) == false && controlerProfesor.buscarCodigo(codigo).puedeaAsignarCurso()){
            this.buscarCurso(codigoCurso).setCodigoProfesor(controlerProfesor.buscarCodigo(codigo));
        }else{
            System.out.println("No se puede agregar profesor o ya tiene profesor o este profesor ya tiene este curso: ");
        }
    }

    public  void definirHorarioSalon(){
        String lunes = "lunes";
        String martes = "martes" ;
        String miercoles = "miercoles";
        String jueves = "jueves";
        String viernes = "viernes";

        String codigo = this.getValidaciones().codigo("ingresa el codigo del curso a definir horarios: ");
        Cursos cursos1 = this.buscarCurso(codigo);
        if(cursos1.getHorario()[1] == null && cursos1.getSalon() == 0){
            int  salon = this.getValidaciones().rango(1,500,"ingresa el numero del salon del curso: ");
            cursos1.setSalon(salon);
            for(int  i= 0; cursos1.getHorario().length > i ; i++){
                if(i == 0){
                    String  horario = this.getValidaciones().validarTexto("ingresa el horario del " + lunes + " si este dia no tienes clase escribe que no hay clase: ");
                    this.buscarCurso(codigo).getHorario()[i] = horario;
                }else if(i == 1){
                    String  horario = this.getValidaciones().validarTexto("ingresa el horario del " + martes + " si este dia no tienes clase escribe que no hay clase: ");
                    this.buscarCurso(codigo).getHorario()[i] = horario;
                }else if(i == 2){
                    String  horario = this.getValidaciones().validarTexto("ingresa el horario del " + miercoles + " si este dia no tienes clase escribe que no hay clase: ");
                    this.buscarCurso(codigo).getHorario()[i] = horario;
                }else if(i == 3){
                    String  horario = this.getValidaciones().validarTexto("ingresa el horario del " + jueves + " si este dia no tienes clase escribe que no hay clase: ");
                    this.buscarCurso(codigo).getHorario()[i] = horario;
                }else{
                    String  horario = this.getValidaciones().validarTexto("ingresa el horario del " + viernes + " si este dia no tienes clase escribe que no hay clase: ");
                    this.buscarCurso(codigo).getHorario()[i] = horario;
                }
            }
        }
    }
}