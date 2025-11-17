
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class App {
//Crea un programa, que tendrá un menú

//  1Consultar tu opción favorita
//  2Escribir tu opción favorita
//  3Salir
//  Si pulsa la opción 1, intentará leer el fichero opcion.txt. El fichero existirá si el usuario en algún momento ha ejecutado la aplicación y ha escrito su tu opción favorita. Si el fichero no existe, mostrará un mensaje al usuario: "DEBES GUARDAR ANTES TUS OPCIONES" Si el fichero existe, mostrará al usuario su opción guardada.

//  Si pulsa la opción 2, preguntará al usuario cuál es su opción favorita, y la guardará en el fichero opcion.txt.
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        final String SALIR = "3";
        final String nombreFichero = "opcion.txt";

        String opcion;
        do {
            System.out.println("1. Consultar tu opción favorita");
            System.out.println("2. Escribir tu opción favorita");
            System.out.println(3.);

            opcion = sc.nextLine();
            switch (opcion) {
                case "1":
                    // Consultar tu opción favorita
                    try {
                        String valor = leerOpcion(nombreFichero);
                        System.out.println("TU OPCIÓN ES: "+ valor);

                    } catch (FileNotFoundException e) {
                        System.out.println("DEBES GUARDAR ANTES TUS OPCIONES");
                    } catch (IOException ex) {
                        System.out.println("viva el jamon serrano");

                    }
                    break;
                case "2":
                    System.out.println("Dime cuál es tu opción ");
                    String favorita = sc.nextLine();
                    // Escribir tu opción favorita
                    escribirOpcion(nombreFichero, favorita);
                    break;
                case "3":
                    // salir
                    System.out.println("FIN DE LA APLICACIÓN");
                    break;
                default:
                    System.out.println("TU SELECCIÓN NO ES VÁLIDA");
                    break;
            }

        } while (!opcion.equals(SALIR));





    }

    private static String leerOpcion(String nombreFichero) throws IOException {
        File fichero = Paths.get(nombreFichero).toFile();
        StringBuilder sb = new StringBuilder();

        FileReader fic = new FileReader(fichero);
        int i;
        while ((i = fic.read()) != -1) // lectura de un carácter
        {
            sb.append((char) i);
        }
        fic.close();

        return sb.toString();
    }

    private static void escribirOpcion(String nombreFichero, String valor) {
        File fichero = Paths.get(nombreFichero).toFile();
        try (FileWriter fic = new FileWriter(fichero)) {
            
            fic.append(valor);

        } catch (IOException ex) {
        }

    }

}


