package es.avellaneda;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;


public class GestorDeAcesos {
    private Map<String, Persona> personasRegistradas;
    private Map<String, Entrada> accesosActivos; // Usamos String como clave para simplificar
    private Map<String, String> historial; // Historial guardado de manera simple

    public GestorDeAcesos() {
        this.accesosActivos = new HashMap<>();
        this.historial = new HashMap<>();
        this.personasRegistradas = cargarPersonas();
    }

    // 🔐 Autenticación
    public Persona autenticar(String numeroEmpleado, String password) throws ExcepcionDeValidacion {
        Persona persona = personasRegistradas.get(numeroEmpleado);
        if (persona == null || !persona.getPasswordHash().equals(password)) {
            throw new ExcepcionDeValidacion("Credenciales incorrectas.");
        }
        return persona;
    }

    // 🏢 Registrar entrada
    public void registrarEntrada(Persona persona, String motivo) throws ExcepcionDeValidacion {
        if (accesosActivos.containsKey(persona.getNumeroEmpleado())) {
            throw new ExcepcionDeValidacion("Entrada ya registrada. Debe registrar salida antes.");
        }

        Entrada entrada = new Entrada(motivo, LocalDate.now(), LocalTime.now(), persona);
        accesosActivos.put(persona.getNumeroEmpleado(), entrada);
        historial.put(persona.getNumeroEmpleado(), entrada.toString());
    }

    // 🚪 Registrar salida
    public void registrarSalida(Persona persona) throws ExcepcionDeValidacion {
        Entrada entrada = accesosActivos.remove(persona.getNumeroEmpleado());

        // Verificar si la persona tenía una entrada registrada
        if (entrada == null) {
            guardarIntentoInvalido(persona);
            throw new ExcepcionDeValidacion("No hay entrada registrada. No puede salir sin haber entrado.");
        }
    
        // Crear la instancia de salida
        Salida salida = new Registro(fecha, hora, persona) ;
        
    
    }

 

    // 📝 Guardar intentos inválidos
    private void guardarIntentoInvalido(Persona persona) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("errores.log", true))) {
            writer.write(String.format("%s - %s - %s - %s - Intento de salida sin registro de entrada\n",
                    LocalDate.now(), LocalTime.now(), persona.getNombreApellidos(), persona.getNumeroEmpleado()));
        } catch (IOException e) {
            System.out.println("No se pudo guardar el intento inválido.");
        }
    }
}