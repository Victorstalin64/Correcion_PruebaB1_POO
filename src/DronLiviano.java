public class DronLiviano extends Dron {
    private double limiteHoras;

    public DronLiviano() {
        setCodigo("LIV001");
        setModelo("LivianoX");
        setDistanciaKm(12.5);
        setPesoPaquete(2.3);
        setHorasVuelo(1.5);
        this.costoBase = 5.00;
        this.limiteHoras = 2.0;
    }

    public double getLimiteHoras() { return limiteHoras; }

    public void setLimiteHoras(double limiteHoras) {
        if (limiteHoras > 0) {
            this.limiteHoras = limiteHoras;
        } else {
            System.out.println("ERROR: El límite de horas debe ser mayor a 0.");
        }
    }

    @Override
    public void setPesoPaquete(double pesoPaquete) {
        if (pesoPaquete > 0 && pesoPaquete <= 5) {
            super.setPesoPaquete(pesoPaquete);
        } else {
            System.out.println("ERROR: El peso excede el límite permitido (5 kg).");
        }
    }

    @Override
    public void setHorasVuelo(double horasVuelo) {
        if (horasVuelo > 0 && horasVuelo <= 2) {
            super.setHorasVuelo(horasVuelo);
        } else {
            System.out.println("ERROR: Las horas de vuelo exceden el límite permitido (2 h).");
        }
    }

    @Override
    public double calcularCostoEntrega() {
        return costoBase + (getDistanciaKm() * 0.80) + (getPesoPaquete() * 0.50);
    }

    @Override
    public boolean validarDatos() {
        if (getPesoPaquete() > 5) return false;
        if (getHorasVuelo() > 2) return false;
        return true;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("--- Dron Liviano ---");
        super.mostrarInformacion();
        System.out.println("Límite de peso: 5 kg");
        System.out.println("Límite de horas: 2 horas");
    }
}