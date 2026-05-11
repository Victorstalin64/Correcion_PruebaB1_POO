public class DronEmergencia extends Dron {
    private double recargoUrgencia;
    private int nivelPrioridad;

    public DronEmergencia() {
        setCodigo("EMG001");
        setModelo("Emergente");
        setDistanciaKm(8.0);
        setPesoPaquete(3.0);
        setHorasVuelo(1.0);
        this.costoBase = 8.00;
        this.recargoUrgencia = 10.0;
        this.nivelPrioridad = 2;
    }

    public double getRecargoUrgencia() { return recargoUrgencia; }
    public int getNivelPrioridad() { return nivelPrioridad; }

    public void setRecargoUrgencia(double recargoUrgencia) {
        if (recargoUrgencia >= 0) {
            this.recargoUrgencia = recargoUrgencia;
        } else {
            System.out.println("ERROR: El recargo de urgencia no puede ser negativo.");
        }
    }

    public void setNivelPrioridad(int nivelPrioridad) {
        if (nivelPrioridad >= 1 && nivelPrioridad <= 3) {
            this.nivelPrioridad = nivelPrioridad;
        } else {
            System.out.println("ERROR: El nivel de prioridad debe estar entre 1 y 3.");
        }
    }

    @Override
    public void setPesoPaquete(double pesoPaquete) {
        if (pesoPaquete > 0 && pesoPaquete <= 10) {
            super.setPesoPaquete(pesoPaquete);
        } else {
            System.out.println("ERROR: El peso excede el límite permitido (10 kg).");
        }
    }

    @Override
    public void setHorasVuelo(double horasVuelo) {
        if (horasVuelo > 0 && horasVuelo <= 3) {
            super.setHorasVuelo(horasVuelo);
        } else {
            System.out.println("ERROR: Las horas de vuelo exceden el límite permitido (3 h).");
        }
    }

    @Override
    public double calcularCostoEntrega() {
        return costoBase + (getDistanciaKm() * 1.00) + (getPesoPaquete() * 0.90) + recargoUrgencia;
    }

    @Override
    public boolean validarDatos() {
        if (getPesoPaquete() > 10) return false;
        if (getHorasVuelo() > 3) return false;
        if (nivelPrioridad < 1 || nivelPrioridad > 3) return false;
        return true;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("--- Dron Emergencia ---");
        super.mostrarInformacion();
        System.out.println("Recargo urgencia: " + recargoUrgencia);
        System.out.println("Nivel prioridad: " + nivelPrioridad);
        System.out.println("Límite de peso: 10 kg");
        System.out.println("Límite de horas: 3 horas");
    }
}
