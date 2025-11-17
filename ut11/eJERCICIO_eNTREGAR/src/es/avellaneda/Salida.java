package es.avellaneda;

import java.time.LocalDate;
import java.time.LocalTime;

public class Salida extends Registro {
    private LocalDate fechaEntrada;
    private LocalTime horaEntrada;

    public Salida(LocalDate fechaEntrada, LocalTime horaEntrada, LocalDate fecha, LocalDate hora, Persona persona) {
        super(fecha, hora, persona);
        this.fechaEntrada = fechaEntrada;
        this.horaEntrada = horaEntrada;
    }

    

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public LocalTime getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(LocalTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    @Override
    public String toString() {
        return "Salida [fechaEntrada=" + fechaEntrada + ", horaEntrada=" + horaEntrada + "]";
    }
}
