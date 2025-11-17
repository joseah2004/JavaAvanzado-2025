package carpeta;
public class LibroDigital extends Libro {
 
    
        double tamañoMB;
                private String tamaño;
        
        
                public LibroDigital(String titulo, String autor, 
                String isbn, double tamanoMB, 
                    String categoriaDewey) {
                super(titulo, autor, isbn, categoriaDewey);
                this.tamañoMB = tamanoMB;
            }
        
        
             
                @Override
                public String toString() {
                    return super.toString() +"LibroDigital [tamaño=" + tamaño + "]";
        }
    

        
}
