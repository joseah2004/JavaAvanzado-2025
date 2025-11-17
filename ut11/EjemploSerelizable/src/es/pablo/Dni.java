package es.pablo;

import java.io.Serializable;
import java.time.LocalDate;

public class Dni implements Serializable {
 private String numero;
 private LocalDate fechaCaducidad;

    public Dni(LocalDate fechaCaducidad, String numero) {
        this.fechaCaducidad = fechaCaducidad;
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public LocalDate getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(LocalDate fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    @Override
    public String toString() {
        return "numero=" + numero + ", fechaCaducidad=" + fechaCaducidad + "]";
    }











 
}
