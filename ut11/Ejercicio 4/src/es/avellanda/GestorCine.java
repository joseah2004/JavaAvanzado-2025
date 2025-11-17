package es.avellanda;

import java.util.Scanner;

public class GestorCine {

    private Scanner sc;


    public  GestorCine(){
        sc = new Scanner(System.in);
    }


    public void gestionarMenu(){
        String opcion;
        do{
        System.out.println("1 Mostrar butacas");
        System.out.println("2 Comprar entradas");
        System.out.println("3 Devolver una entrada");
        System.out.println(" 4 Salir");
        opcion = sc.nextLine();


        switch (opcion) {
            case "1":
                
                break;

                case "2":
                
                break;

                case "3":
                
                break;

                case "4":
                //salr
                break;

        
            default:
                break;
        }
    }while (!opcion.equals("4")) ;
        
    

    }
}
