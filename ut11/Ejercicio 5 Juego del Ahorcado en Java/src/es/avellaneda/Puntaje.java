package es.avellaneda;


public class Puntaje {

    private String alias;
    private int fecha; 
    private int puntuacion;

    public Puntaje(String alias, int fecha, int puntuacion) {
        this.alias = alias;
        this.fecha = fecha;
        this.puntuacion = puntuacion;
    }

    public int getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return "Alias: " + alias + ", Fecha: "  + ", Puntuación: " + puntuacion;
    }
}

