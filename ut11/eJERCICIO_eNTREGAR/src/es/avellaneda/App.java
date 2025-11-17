package es.avellaneda;
import es.avellaneda.Persona;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class App {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
       
    }





    public void mostrarMenu(){
        boolean continua ;
        while (continua = true) { 
            int opcion;
            System.out.println("Elije");
            System.out.println("Elige una opción:");
            System.out.println("1 ..Autenticación de personas con verificación de credenciales.");
            System.out.println("2 ..Registro de entrada y salida del edificio");
            System.out.println("3 ..Consulta de historial de accesos de la persona autenticada.");
            System.out.println("0 ..Salir");
            opcion = sc.nextInt();


            switch (opcion) {
                case 1:
                        System.out.println("1 ..Autenticación de personas con verificación de credenciales.");
                    break;


                case 2:
                        System.out.println("2 ..Registro de entrada y salida del edificio");
                    break;
                
                case 3:
                    System.out.println("3 ..Consulta de historial de accesos de la persona autenticada.");
                break;
            
                default:
                    break;
            }

        }

    }


   








    





 

}
