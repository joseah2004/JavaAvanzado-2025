package es;

public abstract class Persona {
    private String nombre;
    private String Dni;
    private String telefono;
    
    public Persona(String nombre, String dni, String telefono) {
        this.nombre = nombre;
        Dni = dni;
        this.telefono = telefono;
    }






    
    public String getNombre() {
        return nombre;
    }







    public void setNombre(String nombre) {
        this.nombre = nombre;
    }







    public String getDni() {
        return Dni;
    }







    public void setDni(String dni) {
        Dni = dni;
    }







    public String getTelefono() {
        return telefono;
    }







    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }







    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        result = prime * result + ((Dni == null) ? 0 : Dni.hashCode());
        result = prime * result + ((telefono == null) ? 0 : telefono.hashCode());
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
        Persona other = (Persona) obj;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        if (Dni == null) {
            if (other.Dni != null)
                return false;
        } else if (!Dni.equals(other.Dni))
            return false;
        if (telefono == null) {
            if (other.telefono != null)
                return false;
        } else if (!telefono.equals(other.telefono))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Persona [nombre=" + nombre + ", Dni=" + Dni + ", telefono=" + telefono + "]";
    }

    public abstract String DameEltipo();
}
