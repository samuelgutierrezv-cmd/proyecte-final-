package org.samuel.Validador;
import javax.swing.*;
import javax.swing.plaf.basic.BasicTreeUI;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validaciones{
    public String validarTexto(String mensaje){
        boolean valid = true;
        String texto = "";
        while(valid){
            texto = texto(mensaje).trim();
            if(texto ==null || texto.isEmpty() || texto.length() <= 2  ){
                System.out.println("invalid  ingresa de nuevo: ");
            }else{
                valid= false;
            }
        }
        return texto;
    }
    public Carreras ingresarCarrera(){
        String carreras =  null;
        Carreras carrera = null;
        boolean validador = true;
        System.out.println("---------CARRERAS DE LA UNIVERSIDAD---------");
        System.out.println(Carreras.ADMINISTRACION);
        System.out.println(Carreras.INGENIERIACIVIL);
        System.out.println(Carreras.INGENIERIAELECTRICA);
        System.out.println(Carreras.INGENIERIADESISTEMAS);
        System.out.println(Carreras.ARQUITECTURA);
        System.out.println(Carreras.DERECHO);
        System.out.println(Carreras.CONTADURIA);
        System.out.println(Carreras.PERIODISMO);
        System.out.println(Carreras.LICENCIATURAENEDUCACION);
        System.out.println(Carreras.LICENCIATURAENESCRITURA);
        System.out.println(Carreras.LICENCIATURAENMATEMATICAS);
        System.out.println(Carreras.PSICOLOGIA);
        System.out.println(Carreras.MEDICINA);
        while(validador){
            carreras = validarTexto("ingresa la carrera del estudiante: ");
            String carreras2 = carreras.replace(" ","");
            if(carreras2.equalsIgnoreCase(String.valueOf(Carreras.INGENIERIACIVIL))){
                carrera = Carreras.INGENIERIACIVIL;
                validador = false;
            }else if(carreras2.equalsIgnoreCase(String.valueOf(Carreras.ADMINISTRACION))){
                carrera=  Carreras.ADMINISTRACION;
                validador = false;
            }else if(carreras2.equalsIgnoreCase(String.valueOf(Carreras.CONTADURIA))){
                carrera = Carreras.CONTADURIA;
                validador = false;
            }else if(carreras2.equalsIgnoreCase(String.valueOf(Carreras.INGENIERIADESISTEMAS))){
                carrera  = Carreras.INGENIERIADESISTEMAS;
                validador = false;
            }else if(carreras2.equalsIgnoreCase(String.valueOf(Carreras.ARQUITECTURA))){
                carrera =  Carreras.ARQUITECTURA;
                validador = false;
            }else if(carreras2.equalsIgnoreCase(String.valueOf(Carreras.MEDICINA))){
                carrera =  Carreras.MEDICINA;
                validador = false;
            }else if(carreras2.equalsIgnoreCase(String.valueOf(Carreras.INGENIERIAELECTRICA))) {
                carrera =  Carreras.INGENIERIAELECTRICA;
                validador = false;
            }else if(carreras2.equalsIgnoreCase(String.valueOf(Carreras.LICENCIATURAENEDUCACION))) {
                carrera =  Carreras.LICENCIATURAENEDUCACION;
                validador = false;
            }else if(carreras2.equalsIgnoreCase(String.valueOf(Carreras.DERECHO))) {
                carrera =  Carreras.DERECHO;
                validador = false;
            }else if(carreras2.equalsIgnoreCase(String.valueOf(Carreras.PSICOLOGIA))) {
                carrera =  Carreras.PSICOLOGIA;
                validador = false;
            }else if(carreras2.equalsIgnoreCase(String.valueOf(Carreras.PERIODISMO))) {
                carrera =  Carreras.PERIODISMO;
                validador = false;
            }else if(carreras2.equalsIgnoreCase(String.valueOf(Carreras.LICENCIATURAENESCRITURA))) {
                carrera =  Carreras.LICENCIATURAENESCRITURA;
                validador = false;
            }else if(carreras2.equalsIgnoreCase(String.valueOf(Carreras.LICENCIATURAENMATEMATICAS))) {
                carrera =  Carreras.LICENCIATURAENMATEMATICAS;
                validador = false;
            }else{
                System.out.println("ingresa una carera valida.");
            }
        }
        return carrera;
    }
    public String codigo(String mensaje){
        boolean valid = true ;
        String codigo = texto(mensaje).trim() ;
        int contador1 = 0;
        int contador2 = 0;
        while(valid){
            if(codigo != null && codigo.length() == 5){
                if(codigo.charAt(contador1) == '1'|| codigo.charAt(contador1) == '2' || codigo.charAt(contador1) == '3' || codigo.charAt(contador1) == '4'|| codigo.charAt(contador1) == '5'|| codigo.charAt(contador1) == '6'|| codigo.charAt(contador1) == '7'|| codigo.charAt(contador1) == '8'|| codigo.charAt(contador1) == '9' || codigo.charAt(contador1)=='0'){
                    contador2++;
                }else{
                    System.out.println(" el codigo tienen que ser todo numeros ingresa un codigo valido: ");
                    codigo= texto(mensaje).trim();
                    valid = true;
                }
                if(contador2 == 4){
                    valid = false;
                }
                contador1++;
            }else{
                System.out.println("invalido ingresa un codigo valido");
                codigo= texto(mensaje).trim();
                valid = true;
            }
        }
        return codigo;
    }

    public double rangoDecimal(double r1, double r2, String mensaje){
        boolean valid = true;
        double numero = 0;
        while(valid){
            numero = entero(mensaje);
            if(numero < r1 || numero > r2){
                System.out.println("Invalido no esta dentro del rango");
            }else{
                valid = false;
            }
        }
        return numero;
    }

    public int rango(int r1, int r2, String mensaje){
        boolean valid = true;
        int numero = 0;
        while(valid){
            numero = entero(mensaje);
            if(numero < r1 || numero > r2){
                System.out.println("Invalido no esta dentro del rango");
            }else{
                valid = false;
            }
        }
        return numero;
    }

    public LocalDate fecha(String mensaje){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/AAAA");
        String fecha = "";
        while(true){
            fecha = validarTexto(mensaje);
            try{
                LocalDate fechaFor = LocalDate.parse(fecha,dateTimeFormatter);
                LocalDate hoy = LocalDate.now();
                return fechaFor;
            }catch (DateTimeException e){
                System.out.println("formato invalido debes ingresarlo en formato dd/mm/aaaa");
            }
        }
    }
    public String email(String mensaje){
        boolean validador  = true;
        String emailRegex ="^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(emailRegex);
        String email = "";
        while(validador){
            email = texto(mensaje);
            Matcher matcher = pattern.matcher(email);
            if(matcher.matches()){
                validador = false;
                System.out.println("email registrado.");
            }else{
                System.out.println("ingresa de nuevo el email:");
            }
        }
        return email;
    }
    public String texto(String mensaje){
        Scanner sc = new Scanner(System.in);
        System.out.println(mensaje);
        return sc.nextLine();
    }
    public int  entero(String mensaje){
        Scanner sc = new Scanner(System.in);
        System.out.println(mensaje);
        return sc.nextInt();
    }
    public float decimal(String mensaje){
        Scanner sc = new Scanner(System.in);
        System.out.println(mensaje);
        return sc.nextFloat();
    }
    public  String generarCodigo() {
        StringBuilder codigo = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            int numero = (int) (Math.random() * 10); // genera un número entre 0 y 9
            codigo.append(numero);
        }
        return codigo.toString();
    }
}