package es.avellaneda;

import java.util.Comparator;

public class ComparadorPorAlto implements Comparator<Producto>{

    @Override
    public int compare(Producto Producto1, Producto Producto2) {
        return Double.compare(Producto1.getAlto(), Producto2.getAlto());
    }

}
