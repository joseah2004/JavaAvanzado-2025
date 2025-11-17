package es.avellaneda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Ordenaciones{
    public static void main(String[] args) {
        ArrayList<Producto> productos = DAOparticipantes.getProductos();

        mostrarColleccion(productos);
        mostrarColleccion(ordenarAltoProducto(productos));
        Collections.sort(productos);
        mostrarColleccion(Collections.sort(productos));
    }
    
    public static ArrayList<Producto> ordenarAltoProducto(ArrayList<Producto> coleccion) {
        Collections.sort(coleccion, new ComparadorPorAlto());

        return coleccion;
    }

    
    public static ArrayList<Producto> ordenarAnchoProducto(ArrayList<Producto> coleccion) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ordenarAnchoProducto'");
    }

    
    public static ArrayList<Producto> ordenarLargoProducto(ArrayList<Producto> coleccion) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ordenarLargoProducto'");
    }


    public static void mostrarColleccion (ArrayList<Producto> colleccion){
        Iterator<Producto> it = colleccion.iterator();

        while (it.hasNext()) {
            Producto p = it.next();
            System.out.println(p);
        }
    }
}
