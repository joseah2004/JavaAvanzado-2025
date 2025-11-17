package es.avellaneda;

import java.nio.channels.FileChannel.MapMode;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static Map<Integer,String> tetas = new HashMap<>();
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        int opcion;
        System.out.println("Menu");
        System.out.println("1.Insertar contacto");
        System.out.println("2.Consultar contacto (número)" );
        System.out.println("3.Mostrar todos");
        System.out.println("4. Salir");
        opcion = sc.nextInt();
        switch (opcion) {
            case 1:
                try {
                    Insertarcontacto();
                } catch (Exception e) {
                   System.out.println("federico garcia lorca");
                }

                break;
            case 2:
                try {
                    consultarContacto();
                } catch (Exception e) {
                   System.out.println("viva la gasolina");
                }
                
                break;

            case 3:
                mostrarTodos();
                break;

            case 4:
                System.out.println("Se termino ya ");
                break;
        
            default:
                break;
        }

    }
        private static void Insertarcontacto(){
                int numero;
                String nombre;
                System.out.println("numero contacto");
                numero = Integer.parseInt(sc.nextLine());
                System.out.println("nombre contacto");
                nombre = sc.next();
                tetas.put(numero, nombre);
        }




        private static void consultarContacto(){
            String nombre;
            int numero;
            System.out.println("dame el numero que quieras ver");
            numero = Integer.parseInt(sc.nextLine());
            nombre = tetas.get(numero);
            System.out.println("El nombre seria " + nombre);
        }



        private static void mostrarTodos(){
            for (Integer numero : tetas.keySet()) {
                System.out.println("numero es: " + numero + "y el nombre "+ tetas.get(numero));
            }
        }

    
}
