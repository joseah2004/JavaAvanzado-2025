class GestionGastos {
    private List<Participante> participantes;
    private List<ImportePositivoExcepcion> excepciones;
    
    public GestionGastos() {
        this.participantes = new ArrayList<>();
        this.excepciones = new ArrayList<>();
    }
    
    public void agregarParticipante(Participante p) {
        participantes.add(p);
    }
    
    public void calcularPendientes() {
        double totalGastos = participantes.stream()
                .mapToDouble(Participante::calcularSaldo)
                .filter(saldo -> saldo < 0)
                .sum();
        
        double cuotaEquitativa = totalGastos / participantes.size();
        
        System.out.println("Saldo de cada participante:");
        for (Participante p : participantes) {
            double saldo = p.calcularSaldo();
            double diferencia = saldo - cuotaEquitativa;
            System.out.println(p.getNombre() + " tiene un saldo de " + saldo + " y " +
                    (diferencia < 0 ? " debe pagar " + (-diferencia) : " debe recibir " + diferencia));
        }
    }
    
    public void manejarExcepcion(ImportePositivoExcepcion e) {
        excepciones.add(e);
        System.out.println(e.getMessage());
    }
}
