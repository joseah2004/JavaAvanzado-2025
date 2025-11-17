package es;

import java.util.ArrayList;

public class Participante extends Persona{


    private ArrayList<Transaccion> gastosIngresos;

    public Participante(String nombre, String dni, String telefono) {
        super(nombre, dni, telefono);
        gastosIngresos = new ArrayList<>();
    }

    @Override
    public String DameEltipo() {
        return getClass().toString();
    }

}
