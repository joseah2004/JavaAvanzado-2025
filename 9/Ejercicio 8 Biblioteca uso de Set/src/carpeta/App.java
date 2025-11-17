package carpeta;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;


public class App {
    private static DAOclasificaciones daoClasificaciones = new DAOclasificaciones();
    public static void main(String[] args)  {
        


        //hASH SET SIN ORDEN ESPECIFICO
        Set<Libro> libroHashSet = new HashSet<>(DAOlibros.getLibros());

        Set<Libro> librosTreeSet = new TreeSet<>();

        librosTreeSet.addAll(libroHashSet);

        Set<Libro> librosTreeSetTitulo = new TreeSet<>(new ComparadordeTitulo());
        librosTreeSetTitulo.addAll(DAOlibros.getLibros());


        System.out.println("Libros en HashSet (sin orden específico):");
        mostrarLibros(librosTreeSetTitulo);
        System.out.println("*********************");
        System.out.println("*********************");
        System.out.println("*********************");
        System.out.println("*********************");
        System.out.println("\nLibros en TreeSet (ordenados por título automáticamente):");
        mostrarLibrosIterator(librosTreeSetTitulo);

        System.out.println("*********************");
        System.out.println("*********************");
        System.out.println("*********************");
        System.out.println("*********************");
        mostrarLibrosConClasificacion(libroHashSet);
    }









    private static void mostrarLibros(Set<Libro> libros){
        for (Libro libro : libros) {
            System.out.println(libro);
        }

    }
    private static void mostrarLibrosIterator(Set<Libro> libros) {
        Iterator<Libro> iteradorLibros = libros.iterator();
        while (iteradorLibros.hasNext()) {
            System.out.println(iteradorLibros.next());
        }

    }

    private static void mostrarLibrosConClasificacion(Set<Libro> libros) {

        for (Libro libro : libros) {
            String clasificacion = daoClasificaciones.getClasificacion(libro.getCodigoBiblioteca().split(" ")[0]);
            System.out.println(libro + " Categoría: " + clasificacion);
        }
    }
}
