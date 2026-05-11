import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public Main() {}

    public static void main(String[] args) {

        DronLiviano dl = new DronLiviano();
        DronCarga dc = new DronCarga();
        DronEmergencia de = new DronEmergencia();

        System.out.println("===== INFORMACIÓN INICIAL DE DRONES =====");
        dl.mostrarInformacion();
        System.out.println();
        dc.mostrarInformacion();
        System.out.println();
        de.mostrarInformacion();
        System.out.println("==========================================");

        System.out.println("\n===== INGRESO DE NUEVOS DATOS =====");
        System.out.println("¿Qué dron desea actualizar?");
        System.out.println("1. Dron Liviano");
        System.out.println("2. Dron Carga");
        System.out.println("3. Dron Emergencia");
        System.out.print("Opción: ");
        int opcion = Integer.parseInt(sc.nextLine());

        System.out.print("\nIngrese distancia (km): ");
        double distancia = Double.parseDouble(sc.nextLine());
        System.out.print("Ingrese peso del paquete (kg): ");
        double peso = Double.parseDouble(sc.nextLine());
        System.out.print("Ingrese horas de vuelo: ");
        double horas = Double.parseDouble(sc.nextLine());

        Dron dronSeleccionado = null;

        if (opcion == 1) {
            dronSeleccionado = dl;
        } else if (opcion == 2) {
            dronSeleccionado = dc;
        } else if (opcion == 3) {
            dronSeleccionado = de;
        } else {
            System.out.println("Opción inválida.");
            return;
        }

        dronSeleccionado.setDistanciaKm(distancia);
        dronSeleccionado.setPesoPaquete(peso);
        dronSeleccionado.setHorasVuelo(horas);

        if (dronSeleccionado.validarDatos()) {
            System.out.println("\nLos datos cumplen con las validaciones.");
            System.out.print("¿Desea guardar los cambios? (s/n): ");
            String respuesta = sc.nextLine().trim().toLowerCase();

            if (respuesta.equals("s")) {
                System.out.println("Datos actualizados correctamente.");
                System.out.println("\n===== INFORMACIÓN ACTUALIZADA =====");
                dronSeleccionado.mostrarInformacion();
                System.out.println("==========================================");
            } else {
                System.out.println("No se guardaron los cambios.");
            }
        } else {
            System.out.println("\nNo se guardaron los cambios.");
        }

        System.out.println("\n===== DEMOSTRACIÓN DE POLIMORFISMO =====");
        System.out.println("Lista de drones (tipo Dron):");
        Dron[] drones = { dl, dc, de };
        for (Dron d : drones) {
            System.out.printf("-> %s | Modelo: %s | Costo entrega: %.2f%n",
                    d.getCodigo(), d.getModelo(), d.calcularCostoEntrega());
        }

        System.out.println("\nLlamando al método mostrarInformacion() desde referencia Dron:");
        for (Dron d : drones) {
            d.mostrarInformacion();
            System.out.println();
        }

        System.out.println("===== FIN DEL PROGRAMA =====");
        System.out.println("Gracias por usar el sistema de drones.");
        System.out.println("Hasta luego.");
        sc.close();
    }
}