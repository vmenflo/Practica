/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package daw;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Víctor
 */
public class Practica {

    public static void main(String[] args) {
        //Crea una clase con un metodo que lea el contenido y genere objetos
        List<String> datos = Lectura.leerFichero("RelEmpCenAus.csv");
        datos.forEach(System.out::println);
        
        List<Profesores> lista = Lectura.generarListaProfesores(datos);
        lista.forEach(System.out::println);
        
        List<String> puestos = puestosTrabajosDistintos(lista);
        puestos.forEach(System.out::println);
        System.out.println(trabajadoresActivo(lista));
        
        List<String> DNIS = blabla(lista);
        DNIS.forEach(System.out::println);
        
        String[][] matriz = Lectura.leerTxtMatriz("./concierto.txt");
        
        for(int i=0;i<matriz.length;i++){
            for(int j=0;j<matriz[i].length;j++){
                System.out.print(matriz[i][j]);
            }
            System.out.println(" ");
        }
        
        System.out.println("***************");
        List<Profesores> list = Lectura.generarFicheroTxT("./RelEmpCenAus.txt");
        list.forEach(System.out::println);
        
    }
    
    //Métodos con Api Stream
    public static List<String> puestosTrabajosDistintos(List<Profesores> lista){
        return lista.stream()
                .map(t->t.puesto()).distinct().collect(Collectors.toList());
    }
    
    public static int trabajadoresActivo(List<Profesores> lista){
        return (int)lista.stream().filter(T->T.activo().equalsIgnoreCase("s")).count();
    }
    
    //Obetner dnis diferentes de los trabajadores no activos ordenados alfabeticamentes
    public static List<String> blabla(List<Profesores> lista){
        return lista.stream().filter(T-> T.activo().equalsIgnoreCase("n")).map(t->t.DNI()).distinct().sorted((t1,t2)->t1.compareTo(t2)).collect(Collectors.toList());
    }
    
 
}
