package registrosPersonass; 
import java.io.File; 
import java.io.FileInputStream;
 import java.io.FileOutputStream;
 import java.io.IOException; 
 import java.io.ObjectInputStream;
  import java.io.ObjectOutputStream;
  import java.util.ArrayList; 
  import model.Persona; 
  
  public class EstribirUnRegistro { 
    public static ArrayList<Persona> personas = new ArrayList<>();

    public static void main(String[] args) {
        File fichero = new File("./personasRegistradas.dat");
        escribir(getPersonas(), fichero);
    }

    private static ArrayList<Persona> getPersonas() {
        ArrayList<Persona> lista = new ArrayList<>();
        lista.add(new Persona("Uno Uno", "1", "01234"));
        lista.add(new Persona("Dos Dos", "2", "01234"));
        lista.add(new Persona("Tres Tres", "3", "01234"));
        return lista;
    }

    private static void escribir(ArrayList<Persona> personas, File fichero) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero))) {
            oos.writeObject(personas);
            System.out.println("Lista de personas guardada correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean comprobarRegistro(Persona persona, String fichero) throws ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero))) {
            ArrayList<Persona> personasLeidas = (ArrayList<Persona>) ois.readObject();
            return personasLeidas.contains(persona);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}