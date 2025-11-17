package model;
/*
fecha (LocalDate) . hora (hora local). Persona
-Entrada y Salida, heredan de Registro
Entrada tendrá el atributo : motivoEntrada
Salida, tendrá los atributos fechaEntrada, horaEntrada.
ExcepcionDeValidacion: Excepción personalizada para errores de validación.
 */

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;


public class Registro implements Serializable{
    private LocalDate fecha;
    private LocalTime hora;
    private Persona persona;

    
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


    public LocalTime getHora() {
        return hora;
    }


    public void setHora(LocalTime hora) {
        this.hora = hora;
    }


    public Persona getPersona() {
        return persona;
    }


    public void setPersona(Persona persona) {
        this.persona = persona;
    }


    @Override
    public String toString() {
        return "Registro fecha=" + fecha + ", hora=" + hora + ", persona=" + persona ;
    }

    
}
