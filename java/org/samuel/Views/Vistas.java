package org.samuel.Views;

public class Vistas {
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
    public void gestionDeEstudiantes(){
        System.out.println("""
                =================================================================
                =                   Gestion de estudiantes                      =
                =================================================================
                =              1. Registrar nuevos estudiantes                  =
                =       2. Buscar estudiantes por código, nombre o carrera      =
                =           3. Actualizar información de estudiantes            =
                =         4. Listar estudiantes por diferentes criterios        =
                =================================================================
                """);
    }
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
    public void gestionDeInscripciones(){
        System.out.println("""
                =================================================================
                =                Gestión de Inscripciones                       =
                =================================================================
                =             1. Inscribir estudiantes en cursos                =
                =             2. Validar prerrequisitos y cupos                 =
                =       3. Generar lista de espera cuando sea necesario         =
                =================================================================
                """);
    }
    public void gestionDeCalificaiones(){
        System.out.println("""
                =================================================================
                =                Gestión de Calificaciones                      =
                =================================================================
                =         1. Registrar calificaciones por parciales             =
                =           2. Calcular promedios automáticamente               =
                =       3. Determinar estado académico (aprobado/reprobado)     =
                =================================================================
                """);
    }
    public void reportesYConsultas(){
        System.out.println("""
                =================================================================
                =                   Reportes y Consultas                        =
                =================================================================
                =        1. Estudiantes con mejor rendimiento académico         =
                =                 2.Cursos con mayor demanda                    =
                =           3. Profesores con más carga académica               =
                =            4. Estadísticas por carrera y semestre             =
                =================================================================
                """);
    }
}
