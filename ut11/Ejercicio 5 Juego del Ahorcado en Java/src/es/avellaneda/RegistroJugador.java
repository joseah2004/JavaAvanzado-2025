
package es.avellaneda;

import java.time.LocalDate;
import java.util.Scanner;

public class RegistroJugador {

    private String alias;
    private LocalDate fecha; 
    int puntuacion;

    public RegistroJugador(String alias, LocalDate fecha, int puntuacion) {
        this.alias = alias;
        this.fecha = fecha;
        this.puntuacion = puntuacion;
    }

    @Override
    public String toString() {
        return "Alias: " + alias + ", Fecha: " + fecha + ", Puntuación: " + puntuacion;
    }

    public static void jugar() {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce tu alias: ");
        String alias = scanner.nextLine();

        String dibujo = rellenar(); 
        String palabra = rellenar(); 

        if (dibujo == null || palabra == null) {
            System.out.println("Error al seleccionar el dibujo o la palabra.");
            return;
        }

      
        int puntuacion = 100; 

       
        guardarPuntuacion(alias, puntuacion);

        System.out.println("¡Juego terminado! Puntuación: " + puntuacion);
    }

    public static void guardarPuntuacion(String alias, int puntuacion) {
        
        LocalDate fecha = LocalDate.now(); 

       
        RegistroJugador registro = new RegistroJugador(alias, fecha, puntuacion);

       
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ranking.dat", true))) {
            oos.writeObject(registro); // Escribimos el objeto en el archivo
            System.out.println("Puntuación guardada correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   
    public static String rellenar() {
       
        return "Ejemplo";
    }

    public static void main(String[] args) {
        jugar();
    }
}

