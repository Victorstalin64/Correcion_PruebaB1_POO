public class DronCarga extends Dron {
    private double costoPorKg;

    public DronCarga() {
        setCodigo("CAR001");
        setModelo("CargaMax");
        setDistanciaKm(45.0);
        setPesoPaquete(20.0);
        setHorasVuelo(3.0);
        this.costoBase = 6.00;
        this.costoPorKg = 1.20;
    }

    public double getCostoPorKg() { return costoPorKg; }

    public void setCostoPorKg(double costoPorKg) {
        if (costoPorKg > 0) {
            this.costoPorKg = costoPorKg;
        } else {
            System.out.println("ERROR: El costo por kg debe ser mayor a 0.");
        }
    }

    @Override
    public void setPesoPaquete(double pesoPaquete) {
        if (pesoPaquete > 0 && pesoPaquete <= 30) {
            super.setPesoPaquete(pesoPaquete);
        } else {
            System.out.println("ERROR: El peso excede el límite permitido (30 kg).");
        }
    }

    @Override
    public void setHorasVuelo(double horasVuelo) {
        if (horasVuelo > 0 && horasVuelo <= 5) {
            super.setHorasVuelo(horasVuelo);
        } else {
            System.out.println("ERROR: Las horas de vuelo exceden el límite permitido (5 h).");
        }
    }

    @Override
    public double calcularCostoEntrega() {
        return costoBase + (getDistanciaKm() * 1.20) + (getPesoPaquete() * costoPorKg);
    }

    @Override
    public boolean validarDatos() {
        if (getPesoPaquete() > 30) return false;
        if (getHorasVuelo() > 5) return false;
        return true;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("--- Dron Carga ---");
        super.mostrarInformacion();
        System.out.println("Costo por kg: " + costoPorKg);
        System.out.println("Límite de peso: 30 kg");
        System.out.println("Límite de horas: 5 horas");
    }
}