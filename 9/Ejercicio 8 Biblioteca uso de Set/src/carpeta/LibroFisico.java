package carpeta;
public class LibroFisico extends Libro {
        
    
    private int numerodePaginas;
    
    public LibroFisico(String titulo, String autor, String isbn, int numerodePaginas, String categoriaDewey) {
        super(titulo, autor, isbn, categoriaDewey);
        this.numerodePaginas = numerodePaginas;
    }
               
    
    
       
        @Override
        public String toString() {
            return super.toString() + "LibroFisico [numerodePaginas=" + numerodePaginas + "]";
        }


        
    
}
