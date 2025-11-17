package excepciones;

public class ExcepcionDeValidacion extends RuntimeException{
    public ExcepcionDeValidacion(String mensaje){
        super(mensaje);
    }
}
