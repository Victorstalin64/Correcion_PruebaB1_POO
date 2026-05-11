public abstract class Dron {
    private String codigo;
    private String modelo;
    private double distanciaKm;
    private double pesoPaquete;
    private double horasVuelo;
    protected double costoBase;

    public Dron() {}

    public String getCodigo() { return codigo; }
    public String getModelo() { return modelo; }
    public double getDistanciaKm() { return distanciaKm; }
    public double getPesoPaquete() { return pesoPaquete; }
    public double getHorasVuelo() { return horasVuelo; }
    public double getCostoBase() { return costoBase; }

    public void setCodigo(String codigo) {
        if (codigo != null && !codigo.trim().isEmpty()) {
            this.codigo = codigo;
        } else {
            System.out.println("ERROR: El código no puede estar vacío.");
        }
    }

    public void setModelo(String modelo) {
        if (modelo != null && !modelo.trim().isEmpty()) {
            this.modelo = modelo;
        } else {
            System.out.println("ERROR: El modelo no puede estar vacío.");
        }
    }

    public void setDistanciaKm(double distanciaKm) {
        if (distanciaKm > 0) {
            this.distanciaKm = distanciaKm;
        } else {
            System.out.println("ERROR: La distancia debe ser mayor a 0.");
        }
    }

    public void setPesoPaquete(double pesoPaquete) {
        if (pesoPaquete > 0) {
            this.pesoPaquete = pesoPaquete;
        } else {
            System.out.println("ERROR: El peso debe ser mayor a 0.");
        }
    }

    public void setHorasVuelo(double horasVuelo) {
        if (horasVuelo > 0) {
            this.horasVuelo = horasVuelo;
        } else {
            System.out.println("ERROR: Las horas de vuelo deben ser mayores a 0.");
        }
    }

    public abstract double calcularCostoEntrega();
    public abstract boolean validarDatos();

    public void mostrarInformacion() {
        System.out.println("Codigo      : " + codigo);
        System.out.println("Modelo      : " + modelo);
        System.out.println("Distancia   : " + distanciaKm + " km");
        System.out.println("Peso        : " + pesoPaquete + " kg");
        System.out.println("Horas       : " + horasVuelo + " h");
        System.out.println("Costo base  : " + costoBase);
        System.out.println("Costo entrega: " + calcularCostoEntrega());
    }
}