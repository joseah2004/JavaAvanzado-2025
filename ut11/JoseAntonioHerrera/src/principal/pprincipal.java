package principal;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Scanner;
import model.Entrada;
import model.Persona;
import model.Salida;
import registrosPersonass.EstribirUnRegistro;

public class pprincipal {

    public static Scanner sc = new Scanner(System.in);
    public static Persona personaAutenticada;
    public static HashMap<Entrada, Salida> registros = new HashMap<>();
    public  static  Entrada entrada;

    public static void main(String[] args) throws ClassNotFoundException {
        boolean continuar = true;

        while (continuar) {
            System.out.println("BIENVENIDO AL HOTEL");
            System.out.println("1. Autenticación");
            System.out.println("2. Salir");
            int opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    try {
                        personaAutenticada = autenticarPersona();
                        if (personaAutenticada != null) {
                            mostrarMenuAutenticado();
                        }
                    } catch (IOException e) {
                        System.out.println("Error al autenticar al usuario: ");
                        e.printStackTrace();
                    }
                    break;

                case 2:
                    System.out.println("CHAO");
                    continuar = false;
                    break;
            }
        }
    }

    private static void mostrarMenuAutenticado() {
        boolean continuar = true;
    
        while (continuar) {
            System.out.println("\nMenú de opciones:");
            System.out.println("1. Registrar Entrada");
            System.out.println("2. Registrar Salida");
            System.out.println("3. Mostrar Historial");
            System.out.println("4. Cerrar Sesión");
            int opcion = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer del scanner
    
            switch (opcion) {
                case 1:
                    System.out.println("Motivo de entrada:");
                    String motivoE = sc.nextLine(); 
                    registrarEntrada(registros, personaAutenticada, motivoE); 
                    break;
    
                case 2:
                    System.out.println("Motivo de salida:");
                    String motivoS = sc.nextLine(); 
                    registrarSalida(registros, personaAutenticada, motivoS); 
                    break;
    
                case 3:
                    mostrarHistorial();
                    break;
    
                case 4:
                    personaAutenticada = null;
                    System.out.println("Sesión cerrada.");
                    continuar = false;
                    break;
    
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
    private static void borrarConsola() {
        System.out.print("\033[H\033[2J"); 
        System.out.flush();
    }

    // Método para autenticar persona
    public static Persona autenticarPersona() throws IOException, FileNotFoundException {
        System.out.println("Introduce tu código de empleado:");
        String numeroEmpleado = sc.nextLine();
        System.out.println("Introduce tu contraseña:");
        String password = sc.nextLine();

        Persona personaTemp = new Persona("", numeroEmpleado, password);

        try {
            if (EstribirUnRegistro.comprobarRegistro(personaTemp, "./personasRegistradas.dat")) {
                return personaTemp;
            } else {
                System.out.println("Credenciales incorrectas.");
                return null;
            }
        } catch (Exception e) {
            if (e.getMessage().contains("personasRegistradas.dat")) {
                System.out.println("El archivo de personas registradas no se encontró. Asegúrate de que el archivo 'personasRegistradas.dat' existe en la ruta correcta.");
            } else {
                System.out.println("Error al autenticar al usuario:");
                e.printStackTrace();
            }
        }
        return null;
    }

    // Método para registrar entrada
    public static void registrarEntrada(HashMap<Entrada, Salida> registros, Persona persona, String motivo) {
        for (Entrada entrada : registros.keySet()) {
            if (entrada.getPersona().equals(persona) && registros.get(entrada) == null) {
                System.out.println("Ya existe una entrada sin registrar salida.");
                return;
            }
        }
        Entrada nuevaEntrada = new Entrada(LocalDate.now(), LocalTime.now(), persona, motivo);
        registros.put(nuevaEntrada, null);
    
        
        guardarRegistroEntrada(registros);
    
        System.out.println("Entrada registrada correctamente.");
    }
    
    // Método para registrar salida
   public static void registrarSalida(HashMap<Entrada, Salida> registros, Persona persona, String motivoSalida) {
    Entrada entradaPendiente = null;

    for (Entrada entrada : registros.keySet()) {
        if (entrada.getPersona().equals(persona) && registros.get(entrada) == null) {
            entradaPendiente = entrada;
            break;
        }
    }

    if (entradaPendiente == null) {
        
        registrarSalidaNoAutorizada(persona);
        return;
    }

    
    Salida salida = new Salida(LocalDate.now(), LocalTime.now(), persona, entrada.getFecha(), entrada.getHora());

   
    registros.put(entradaPendiente, salida);

    
    guardarRegistroSalida(registros);

    System.out.println("Salida registrada correctamente.");
}
    
    // Método para registrar salida no autorizada
    private static void registrarSalidaNoAutorizada(Persona persona) {
        String log = LocalDate.now() + " " + LocalTime.now() + " " +
        persona.getNombreApellidos() + " " + persona.getNumeroEmpleado() + " - intento de salida sin registro de entrada\n";
    
        try (FileWriter fw = new FileWriter("salidaNoautorizada.log", true)) {
            fw.write(log);
            System.out.println("Salida no autorizada registrada.");
        } catch (IOException e) {
            System.out.println("Error al registrar salida no autorizada.");
            e.printStackTrace();
        }
    }
    
    // Método para guardar el registro de salidas y he crado otro para guardar la entrada en documentos
    // distintos , no se si se hacia asi
    public static void guardarRegistroSalida(HashMap<Entrada, Salida> registros) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("registroDeSalida.dat"))) {
            HashMap<Entrada, Salida> salidas = new HashMap<>();
            for (Entrada entrada : registros.keySet()) {
                if (registros.get(entrada) != null) { 
                    salidas.put(entrada, registros.get(entrada));
                }
            }
            oos.writeObject(salidas);
            System.out.println("El registro de salidas está guardado en 'registroDeSalida.dat'.");
        } catch (IOException e) {
            System.out.println("Error al guardar el registro de salidas.");
            e.printStackTrace();
        }
    }
    
    // Método para guardar solo el registro de entradas e
    public static void guardarRegistroEntrada(HashMap<Entrada, Salida> registros) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("registroEntradas.dat"))) {
            HashMap<Entrada, Salida> entradas = new HashMap<>();
            for (Entrada entrada : registros.keySet()) {
                if (registros.get(entrada) == null) {
                    entradas.put(entrada, null);
                }
            }
    
            
            oos.writeObject(entradas);
            System.out.println("El registro de entradas está guardado en 'registroEntradas.dat'.");
        } catch (IOException e) {
            System.out.println("Error al guardar el registro de entradas.");
            e.printStackTrace();
        }
    }
    
    // Método para mostrar el historial de entradas y salidas, si esta vacio no lo hare y mostrara un mensaje
    private static void mostrarHistorial() {
        if (registros.isEmpty()) {
            System.out.println("No hay registros disponibles");
            return;
        }
    
        for (Entrada entrada : registros.keySet()) {
            if (entrada.getPersona().equals(personaAutenticada)) {
                System.out.println("Entrada:    " + entrada.getFecha() + " " + entrada.getHora() + " Motivo: " + entrada.getMotivoEntrada());
                Salida salida = registros.get(entrada);
                if (salida != null) {
                    System.out.println("Salida     " + salida.getHora() );
                } else {
                    System.out.println("Salida   ---- Aun no registrada");
                }
            }
        }
    }

}