package es.avellaneda;

import java.util.ArrayList;

public class DAOparticipantes {

    private static ArrayList<Producto> productos = new ArrayList<>();

    public static ArrayList<Producto> getProductos(){

        if (productos == null) {
            productos = new ArrayList();
            productos.add(new Producto("CHAMPU"));
            productos.add(new Producto("VICTOR", 1, 1, 1));
            productos.add(new Producto("ALCAPARRA", 31, 11, 11));
            productos.add(new Producto("CAMIZONEH", 15, 15, 15));
            productos.add(new Producto("ZARCILLO", 15, 15, 15));
        }

        return productos;
    }
}
