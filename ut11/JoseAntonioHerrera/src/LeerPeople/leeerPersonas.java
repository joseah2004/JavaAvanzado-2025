package LeerPeople;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import model.Persona;

public class leeerPersonas {
    public ArrayList<Persona> leer() throws IOException {
        ArrayList<Persona> listaPersonas = new ArrayList<>();
        File fichero = new File("personasRegistradas.dat");

        if (!fichero.exists()) {
            System.out.println("El archivo no existe.");
            return listaPersonas;
        }

        try (DataInputStream dataIS = new DataInputStream(new FileInputStream(fichero))) {
            while (true) {
                try {
                    String nombreApellidos = dataIS.readUTF();
                    String numeroEmpleado = dataIS.readUTF();
                    String password = dataIS.readUTF();
                    listaPersonas.add(new Persona(nombreApellidos, numeroEmpleado, password));
                } catch (EOFException e) {
                    break; // Fin del archivo
                }
            }
        }

        return listaPersonas;
    }
}
