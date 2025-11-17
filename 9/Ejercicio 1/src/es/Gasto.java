package es;

public class Gasto implements Transaccion{
    private double importe;
    private CategoriaGasto categoria;
    private String detalle;
    
    public Gasto(double importe, CategoriaGasto categoria, String detalle) throws GastoInvalidoException {
        if (importe < 0) {
            throw new GastoInvalidoException("El gasto no puede ser negativo: " + importe);
        }
        this.importe = -importe; // Se almacena como negativo
        this.categoria = categoria;
        this.detalle = detalle;
    }
    
    @Override
    public double getImporte() {
        return importe;
    }
    
    @Override
    public String getDetalle() {
        return detalle;
    }
}

