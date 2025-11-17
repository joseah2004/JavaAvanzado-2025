

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.Pipe.SourceChannel;
import java.nio.file.Paths;
import java.util.Scanner;

public class Principal {
// Crea un programa, que tendrá un menú

// Consultar tus opciones favoritas
// Escribir tus opciones favoritas
// Salir
// Si pulsa la opción 1, intentará leer el fichero opciones.txt. El fichero existirá si el usuario en algún momento ha ejecutado la aplicación y ha escrito sus opciones favoritas.

// Si el fichero no existe, mostrará un mensaje al usuario: "DEBES GUARDAR ANTES TUS OPCIONES" Si el fichero existe, mostrará al usuario su opción guardada.

// Si pulsa la opción 2, preguntará al usuario cuál es su opción favorita, y la guardará en el fichero opciones.txt. Continuará preguntando al usuario por su opción favorita, hasta que el usuario escriba SALIR (o salir).
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    final String SALIR = "3";
    final String nombreFichero = "opcion.txt";

    String opcion;
    do {
        System.out.println("1. Consultar tu opción favorita");
        System.out.println("2. Escribir tu opción favorita");
        System.out.println("3. Salir");

        opcion = sc.nextLine();
        switch (opcion) {
            case "1":
                try {
                    String valor = leerOpcion(nombreFichero);
                    System.out.println("TU OPCIÓN ES: " + valor);
                } catch (FileNotFoundException e) {
                    System.out.println("DEBES GUARDAR ANTES TUS OPCIONES");
                } catch (IOException ex) {
                    System.out.println("Error al leer el archivo.");
                }
                break;
            case "2":
                System.out.println("Dime cuál es tu opcion favorita:");
                while (true) {
                    String favorita = sc.nextLine();
                    if (favorita.equalsIgnoreCase("SALIR")) {
                        break;
                    }
                    escribirOpcion(nombreFichero, favorita);
                    System.out.println("Opcion guardada. ¿Quieres escribir otra opción? Si no, escribe 'SALIR'.");
                }
                break;
            case "3":
                System.out.println("FIN DE LA APLICACIÓN");
                break;
            default:
                System.out.println("TU SELECCIÓN NO ES VaLIDA");
                break;
        }

    } while (!opcion.equals(SALIR));

    
}

private static String leerOpcion(String nombreFichero) throws IOException {
    File fichero = Paths.get(nombreFichero).toFile();
    if (!fichero.exists()) {
        throw new FileNotFoundException("El archivo no existe.");
    }

    StringBuilder sb = new StringBuilder();
    try (FileReader fic = new FileReader(fichero)) {
        int i;
        while ((i = fic.read()) != -1) {
            sb.append((char) i);
        }
    }
    return sb.toString();
}


private static void escribirOpcion(String nombreFichero, String valor) {
    File fichero = Paths.get(nombreFichero).toFile();
    try (FileWriter fic = new FileWriter(fichero, true)) {  // 'true' para no sobrescribir, sino agregar al final
        fic.append(valor + "\n");
        System.out.println("Opción favorita guardada.");
    } catch (IOException ex) {
        System.out.println("Error al escribir en el archivo.");
    }
}
}