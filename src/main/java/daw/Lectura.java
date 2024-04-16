/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Víctor
 */
public class Lectura {
    //LEER DEL CSV
        public static List<String> leerFichero(String nombreFichero) {
        //Creamos una lista para almacenar la que nos devolvera ReadAllLines
        List<String> lista = new ArrayList<>();
        //Importante usar un try para controlar una posible excepcion
        try {
            lista = Files.readAllLines(Paths.get(nombreFichero),StandardCharsets.ISO_8859_1);
        } catch (IOException ex) {
            System.out.println("Error accediendo a " + nombreFichero);
        }
        lista.remove(0);//Eliminamos la primera porque no tiene el formato
        return lista;
    }

    public static List<Profesores> generarListaProfesores(List<String> lista) {
        //Creouna lista que devolvere
        List<Profesores> listaDevolver = new ArrayList();

        for (int i = 0; i < lista.size(); i++) {
            //Separamos por , para obtener los datos de cada vehiculo
            String[] datos = lista.get(i).split("\",\"");//Corta por cada coma
            for (String dato : datos) {
                System.out.println(dato);
            }
            //Si el horario personal es si entonces es true sino false
            boolean horario=true;
            if(datos[4].equalsIgnoreCase("no")){
                horario=false;
            }
            
            //Validar el dia
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate fecha = LocalDate.parse(datos[5], formatter);
            
            
            //Segunda fecha
            LocalDate fecha2 = null;
            if(!datos[6].isEmpty()){
                fecha2 = LocalDate.parse(datos[6], formatter);
            }
            
            
            //La hora
            // Definimos el formato esperado de la cadena de hora
        DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("H:mm");

        // Utilizamos el DateTimeFormatter para analizar la cadena y obtener un objeto LocalTime
        LocalTime hora = LocalTime.parse(datos[7], formatterHora);
            
            //Creamos un objeto de vehiculo y metemos los datos en cada campo
            Profesores temporal = new Profesores(datos[0], datos[1], datos[2], datos[3], horario, fecha, fecha2, hora, datos[8], datos[9]);
            listaDevolver.add(temporal);

        }

        return listaDevolver;
    }
    
    //Lectura de un txt a una matriz
    public static String[][] leerTxtMatriz(String ruta){
        String[][] matriz = null;
        List<String> lista = new ArrayList<>();
        try {
            lista = Files.readAllLines(Paths.get("concierto.txt"),
                    StandardCharsets.UTF_8);
            
         matriz = new String[lista.size()][];
        for(int i=0;i<lista.size();i++){
            matriz[i] = new String[lista.get(i).length()];
            for(int j=0; j<lista.get(i).length();j++){
                matriz[i][j]=String.valueOf(lista.get(i).charAt(j));
            }
        }
        } catch (IOException ex) {
            System.out.println("Error leyendo el fichero");
        
        }

        return matriz;
    }
    
    //Método de leer fichero TXT a Objeto personas
    public static List<Profesores> generarFicheroTxT(String ruta){
        List<String> lista = new ArrayList<>();
        try {
            lista = Files.readAllLines(Paths.get(ruta),
                    StandardCharsets.ISO_8859_1);
        } catch (IOException ex) {
            System.out.println("Error leyendo el fichero");
        }
        List<Profesores> listado = new ArrayList<>();
        for(int i=9;i<lista.size();i++){
            //Separamos por , para obtener los datos de cada vehiculo
            String[] datos = lista.get(i).split("|");//Corta por cada coma
            //Si el horario personal es si entonces es true sino false
            boolean horario=true;
            if(datos[4].equalsIgnoreCase("no")){
                horario=false;
            }
            
            //Validar el dia
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate fecha = LocalDate.parse(datos[5], formatter);
            
            //Segunda fecha
            LocalDate fecha2 = null;
            if(!datos[6].isEmpty()){
                fecha2 = LocalDate.parse(datos[6], formatter);
            }
            
            
            //La hora
            // Definimos el formato esperado de la cadena de hora
        DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("H:mm");

        // Utilizamos el DateTimeFormatter para analizar la cadena y obtener un objeto LocalTime
        LocalTime hora = LocalTime.parse(datos[7], formatterHora);
            
            //Creamos un objeto de vehiculo y metemos los datos en cada campo
            Profesores temporal = new Profesores(datos[0], datos[1], datos[2], datos[3], horario, fecha, fecha2, hora, datos[8], datos[9]);
            listado.add(temporal);
        }
        return listado;
    }
            
}
