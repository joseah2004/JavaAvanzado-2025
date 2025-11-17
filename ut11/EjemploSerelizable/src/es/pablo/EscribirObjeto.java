package es.pablo;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

public class EscribirObjeto {
    public static void main(String[] args) {
        Persona p = new Persona(25, "Ana");
        Dni d = new Dni(LocalDate.of(2027, 4, 10), "09065196E");

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("persona.dat"))) {
            oos.writeObject(p);
            System.out.println("Objeto guardado correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
