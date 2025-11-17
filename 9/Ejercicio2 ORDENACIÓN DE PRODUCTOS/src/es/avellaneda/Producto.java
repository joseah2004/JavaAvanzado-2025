package es.avellaneda;
// Se ordenará por criterio natural por el atributo de nombre.
// Es posible crear un Producto con el nombre, 
// de forma que las medidas por defecto son las mínimas expresadas a continuación.
// Los datos del paquete no podrán ser modificados una vez creados.
// Todos los productos están empaquetados en cajas con medidas que no superan los siguientes límites:
public class Producto implements Comparable<Producto>{
    private String nombre;
    private double alto,ancho,largo;

   

    @Override
    public int compareTo(Producto producto) {
        return nombre.compareTo(producto.nombre);
    }



    public Producto(String nombre) {
        this.nombre = nombre;
        this.alto = 2;
        this.ancho = 2;//los inicializamos y le ponemos valores por defecto
        this.largo = 2;
    }



    public Producto(String nombre, double alto, double ancho, double largo) {
        this.nombre = nombre;
        this.alto = alto;
        this.ancho = ancho;//los inicializamos y le ponemos valores por defecto
        this.largo = largo;
        //Alto: desde 2 cm hasta 30 cm 
        if (this.alto < 2) {
            this.alto = 2;
        }
        else if (alto > 30) {
            this.alto =30;
        }

        //Ancho: desde 2 cm hasta 10 cm 
        if (this.ancho < 2) {
            this.ancho = 2;
        }
        else if (ancho > 10) {
            this.ancho =10;
        }
        //Largo: desde 2 cm hasta 10 cm 
        if (this.largo < 2) {
            this.largo = 2;
        }
        else if (largo > 10) {
            this.largo = 10;
        }
        
    }



    public String getNombre() {
        return nombre;
    }



    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    public double getAlto() {
        return alto;
    }



    public void setAlto(double alto) {
        this.alto = alto;
    }



    public double getAncho() {
        return ancho;
    }



    public void setAncho(double ancho) {
        this.ancho = ancho;
    }



    public double getLargo() {
        return largo;
    }



    public void setLargo(double largo) {
        this.largo = largo;
    }



    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        long temp;
        temp = Double.doubleToLongBits(alto);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(ancho);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(largo);
        result = prime * result + (int) (temp ^ (temp >>> 32));
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
        Producto other = (Producto) obj;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        if (Double.doubleToLongBits(alto) != Double.doubleToLongBits(other.alto))
            return false;
        if (Double.doubleToLongBits(ancho) != Double.doubleToLongBits(other.ancho))
            return false;
        if (Double.doubleToLongBits(largo) != Double.doubleToLongBits(other.largo))
            return false;
        return true;
    }



    @Override
    public String toString() {
        return "Producto [nombre=" + nombre + ", alto=" + alto + ", ancho=" + ancho + ", largo=" + largo + "]";
    }


    
}
