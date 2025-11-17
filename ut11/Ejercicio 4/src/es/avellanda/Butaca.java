package es.avellanda;
public class Butaca { 
    private int asiento, fila; 
    private boolean ocupado;


    public Butaca(int f, int a){ 
    asiento=a; 
    fila=f; 
    ocupado = false;
    } 
    
    public Butaca(String s){ 
    String[] b=s.split(":"); 
    fila=Integer.parseInt(b[0]); 
    asiento=Integer.parseInt(b[1]); 
    } 
    public int getAsiento() { 
    return asiento; 
    } 
    public int getFila() { 
    return fila; 
    } 

    
    
    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + asiento;
        result = prime * result + fila;
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
        Butaca other = (Butaca) obj;
        if (asiento != other.asiento)
            return false;
        if (fila != other.fila)
            return false;
        if (ocupado != other.ocupado)
            return false;
        return true;
    }

    public String toString(){ 
    return fila+":"+asiento; 
    } 
   } 