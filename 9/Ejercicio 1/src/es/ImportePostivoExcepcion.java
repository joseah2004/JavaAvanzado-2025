package es;

public class ImportePostivoExcepcion {
    private Persona persona;
    private double saldo;
    
    public ImportePositivoExcepcion(Persona persona, double saldo) {
        super("El participante " + persona.getNombre() + " tiene saldo positivo de " + saldo);
        this.persona = persona;
        this.saldo = saldo;
    }
}
