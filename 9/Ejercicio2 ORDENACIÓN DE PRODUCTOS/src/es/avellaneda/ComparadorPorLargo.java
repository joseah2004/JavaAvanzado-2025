


public class ComparadorPorLargo implements Comparator<Producto>{




    @Override
    public int compare(Producto Producto1, Producto Producto2) {
        return Double.compare(Producto1.getAncho(), Producto2.getAncho());
    }
}


