package carpeta;
public class Libro  implements Comparable<Libro>{

    private String titulo,autor,isbn;
    private String codigoBiblioteca;

    public Libro(String titulo, String autor, String isbn, String categoriaDewey) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.codigoBiblioteca = generarCodigo(categoriaDewey);
    }




    private String generarCodigo(String categoriaDewey ){
        String inicialesTitulo = titulo.length() >= 3 ? titulo.substring(0,3).toUpperCase() : titulo.toUpperCase();
        return categoriaDewey + "" + "" +inicialesTitulo;
    }
    
    @Override
    public int compareTo(Libro libro) {
        int comparacionDelCodigo = this.codigoBiblioteca.compareTo(libro.codigoBiblioteca);
        return (comparacionDelCodigo !=0) ? comparacionDelCodigo : this.titulo.compareTo(autor);
    }




    public String getTitulo() {
        return titulo;
    }




    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }




    public String getAutor() {
        return autor;
    }




    public void setAutor(String autor) {
        this.autor = autor;
    }




    public String getIsbn() {
        return isbn;
    }




    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }




    public String getCodigoBiblioteca() {
        return codigoBiblioteca;
    }




    public void setCodigoBiblioteca(String codigoBiblioteca) {
        this.codigoBiblioteca = codigoBiblioteca;
    }




    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
        result = prime * result + ((autor == null) ? 0 : autor.hashCode());
        result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
        result = prime * result + ((codigoBiblioteca == null) ? 0 : codigoBiblioteca.hashCode());
        return result;
    }




    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Libro other = (Libro) obj;
        if (titulo == null) {
            if (other.titulo != null)
                return false;
        } else if (!titulo.equals(other.titulo))
            return false;
        if (autor == null) {
            if (other.autor != null)
                return false;
        } else if (!autor.equals(other.autor))
            return false;
        if (isbn == null) {
            if (other.isbn != null)
                return false;
        } else if (!isbn.equals(other.isbn))
            return false;
        if (codigoBiblioteca == null) {
            if (other.codigoBiblioteca != null)
                return false;
        } else if (!codigoBiblioteca.equals(other.codigoBiblioteca))
            return false;
        return true;
    }




    @Override
    public String toString() {
        return "Libro [titulo=" + titulo + ", autor=" + autor + ", isbn=" + isbn + ", codigoBiblioteca="
                + codigoBiblioteca + "]";
    }

    
}
