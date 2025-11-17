package es;

public class Gasto implements Transaccion{
    private Categoria categoria;  
    private String detalle;
    private double importeGasto;
    
    
    
public Gasto(Categoria categoria, String detalle, double importeGasto) {
    if (importeGasto <0) {
        throw new GastoInvalidoException();
    }
    this.categoria = categoria;
    this.detalle = detalle;
    this.importeGasto = importeGasto;
}
    
    



    
public Categoria getCategoria() {
    return categoria;
}




public void setCategoria(Categoria categoria) {
    this.categoria = categoria;
}



public String getDetalle() {
    return detalle;
}



public void setDetalle(String detalle) {
    this.detalle = detalle;
}



public double getImporteGasto() {
    return importeGasto;
}



public void setImporteGasto(double importeGasto) {
    this.importeGasto = importeGasto;
}



    @Override
    public Double devolverImporte() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'devolverImporte'");
  

 }

}
