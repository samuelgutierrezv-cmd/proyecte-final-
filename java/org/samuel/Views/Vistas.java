package org.samuel.Views;

public class Vistas {

    //Vista principal de opciones

    public void principal(){
        System.out.println("""
                ================================================================
                =               Sistema de gestion universitaria               =
                ================================================================
                =                  1. Gestion de estudiantes                   =
                =                  2. Gestion de profesores                    =
                =                  3. Gestion de cursos                        =
                =                  4. Gestion de inscriptions                  =
                =                  5. Gestion de calificaciones                =
                =                  6. Reportes y consultas                     =
                =                  7.       salir                              =
                ================================================================
                """);
    }

    //vista principal de lo que se puede hacer con los estudiantes

    public void gestionDeEstudiantes(){
        System.out.println("""
                =================================================================
                =                   Gestion de estudiantes                      =
                =================================================================
                =              1. Registrar nuevos estudiantes                  =
                =             2. Buscar estudiantes por código                  =
                =           3. Actualizar información de estudiantes            =
                =         4. Listar estudiantes por diferentes criterios        =
                =================================================================
                """);
    }

    //vista principal de lo que se puede hacer con los PROFESORES
    public void gestionDeProfesor(){
        System.out.println("""
                =================================================================
                =                   Gestión de Profesores                       =
                =================================================================
                =          1. Registrar profesores con especialidades           =
                =              2. Asignar profesores a cursos                   =
                =           3. Consultar carga académica por profesor           =
                =================================================================
                """);
    }

    //vista principal de lo que se puede hacer con los CURSOS

    public void gestionDeCursos(){
        System.out.println("""
                =================================================================
                =                     Gestión de Cursos                         =
                =================================================================
                =            1. Crear cursos con información completa           =
                =           2. Definir prerrequisitos y cupos máximos           =
                =            3. Programar horarios y asignar salones            =
                =================================================================
                """);
    }

    //vista principal de lo que se puede hacer con los INSCRIPCIONES

    public void gestionDeInscripciones(){
        System.out.println("""
                =================================================================
                =                Gestión de Inscripciones                       =
                =================================================================
                =             1. Inscribir estudiantes en cursos                =
                =             2. Validar prerrequisitos y cupos                 =
                =================================================================
                """);
    }

    //vista principal de lo que se puede hacer con las Calificaciones

    public void gestionDeCalificaiones(){
        System.out.println("""
                =================================================================
                =                Gestión de Calificaciones                      =
                =================================================================
                =         1. Registrar calificaciones por parciales             =
                =           2.     ingresar nota final                          =
                =           3. Calcular promedios automáticamente               =
                =       4. Determinar estado académico (aprobado/reprobado)     =
                =================================================================
                """);
    }

    //Toda la information que se puede consultar.

    public void reportesYConsultas(){
        System.out.println("""
                =================================================================
                =                   Reported y Consultas                        =
                =================================================================
                =                 1.Cursos con mayor demanda                    =
                =           2. Profesores con más carga académica               =
                =================================================================
                """);
    }
}
