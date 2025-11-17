package es;

import java.util.ArrayList;
import java.util.List;

abstract  class Persona {
protected String nombre;
    protected List<Transaccion> transacciones;
    
    public Persona(String nombre) {
        this.nombre = nombre;
        this.transacciones = new ArrayList<>();
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void agregarTransaccion(Transaccion t) throws ImportePositivoExcepcion {
        transacciones.add(t);
        if (calcularSaldo() > 0) {
            throw new ImportePositivoExcepcion(this, calcularSaldo());
        }
    }
    
    public double calcularSaldo() {
        return transacciones.stream().mapToDouble(Transaccion::getImporte).sum();
    }
}
