package es.avellaneda;


import java.time.LocalDate;
import java.time.LocalTime;

public class Entrada extends Registro {
    private String motivoEntrada;

    public Entrada(LocalDate fecha, LocalTime hora, Persona persona, String motivoEntrada) {
        super(fecha, hora, persona);
        this.motivoEntrada = motivoEntrada;
    }


    @Override
    public String toString() {
        return "Entrada [motivoEntrada=" + motivoEntrada + ", getFecha()=" + getFecha() + ", getHora()=" + getHora()
                + ", getPersona()=" + getPersona() + "]";
    }

    

    
}
