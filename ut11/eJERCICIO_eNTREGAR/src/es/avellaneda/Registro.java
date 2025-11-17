package es.avellaneda;

import java.time.LocalDate;
import java.time.LocalTime;

public abstract class Registro {
    protected LocalDate fecha;
    protected LocalTime hora;
    protected Persona persona;

    public Registro(LocalDate fecha, LocalTime hora, Persona persona) {
        this.fecha = fecha;
        this.hora = hora;
        this.persona = persona;
    }



    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

  
    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    

    public LocalTime getHora() {
        return hora;
    }



    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "Registro [fecha=" + fecha + ", hora=" + hora + ", persona=" + persona + "]";
    }



   

    

    
}
