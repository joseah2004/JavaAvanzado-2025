package es.pablo;
import java.io.Serializable;

 class Persona implements Serializable { // nos permite ir objeto por objeto guardandolo
    private static final long serialVersionUID = 1L; 
    private String nombre;
    private int edad;
   

    public Persona(int edad, String nombre) {
       
        this.edad = edad;
        this.nombre = nombre;
    }

    

    @Override
    public String toString() {
        return nombre + " - " + edad + " años";
    }



    
    



  


    
}
