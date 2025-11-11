package org.samuel.Controlers;

import org.samuel.Validador.Validaciones;
import org.samuel.models.Cursos;

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
    public  Cursos buscarCurso(String codigo){
        Validaciones validaciones =  new Validaciones();
        Cursos curso = null;
        boolean valid =  true;
        while(valid){
            codigo = validaciones.codigo("ingrese de nuevo el codigo del curso");
            for(int i =  0 ; i < this.getCursos().size(); i++){
                if(this.getCursos().get(i).getCodigo().equalsIgnoreCase(codigo)){
                    curso = this.getCursos().get(i);
                }
            }
            if(curso == null){
                System.out.println("curso no encontrado : ");
            }else{
                valid = false;
            }
        }
        return curso;
    }

    public void definirPrerrequisitosCupos(){
        String codigo = this.getValidaciones().codigo("ingresa el codigo del curso: ");
        for(int i =  0; i < this.getCursos().size() ; i++){
            if(this.getCursos().get(i).getCodigo().equalsIgnoreCase(codigo)){
                this.getCursos().get(i).setCupoMaximo(this.getValidaciones().rango(1,50,"ingresa el amximo de cupos que debe tener este curso:"));
                this.getCursos().get(i).setCarreraRequisito(this.getValidaciones().ingresarCarrera());
                this.getCursos().get(i).setSemestreRequisito(this.getValidaciones().rango(1,11,"ingresa el semestre que debe cursar: "));
                this.getCursos().get(i).setPromedioRequisito(this.getValidaciones().rango(1,5,"ingresa el promedio minim que debe tener el estudiante: "));
            }
        }
    }
}
