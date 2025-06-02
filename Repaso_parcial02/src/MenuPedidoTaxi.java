import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase que representa el menú de interacción para solicitar viajes en taxi.
 * Permite al usuario ingresar información de su viaje, realizar pedidos,
 * mostrar datos del viaje y crear nuevos pedidos.
 */
public class MenuPedidoTaxi {

    private final Scanner sc = new Scanner(System.in);
    private PedidoTaxi pedidoTaxi;

    /**
     * Constructor por defecto.
     */
    public MenuPedidoTaxi() {
    }

    /**
     * Constructor con pedido preexistente.
     *
     * @param pedidoTaxi Objeto de tipo PedidoTaxi que se utilizará para registrar los viajes.
     */
    public MenuPedidoTaxi(PedidoTaxi pedidoTaxi) {
        this.pedidoTaxi = pedidoTaxi;
    }

    /**
     * Obtiene el pedido de taxi actual.
     *
     * @return Objeto de tipo PedidoTaxi.
     */
    public PedidoTaxi getPedidoTaxi() {
        return pedidoTaxi;
    }

    /**
     * Asigna el pedido de taxi.
     *
     * @param pedidoTaxi Objeto de tipo PedidoTaxi.
     */
    public void setPedidoTaxi(PedidoTaxi pedidoTaxi) {
        this.pedidoTaxi = pedidoTaxi;
    }

    /**
     * Método inicial. Puede usarse para configuraciones adicionales antes del menú.
     */
    public void iniciarMenu() {
        // Puede usarse para lógica futura si se requiere.
    }

    /**
     * Muestra el menú principal para realizar pedidos de taxi.
     * Incluye opciones para realizar viaje, mostrar datos o salir.
     */
    public void menuPedidoTaxi() {
        int opcion = 0;

        System.out.print("Ingrese su nombre: ");
        String nombreCliente = sc.nextLine();

        System.out.print("Ingrese la fecha de su pedido (YYYY-MM-DD): ");
        String fechaPedido = sc.nextLine();

        pedidoTaxi.setNombreCliente(nombreCliente);
        pedidoTaxi.setFecha(LocalDate.parse(fechaPedido));

        while (!pedidoTaxi.programarPedido()) {
            System.out.print("Por favor ingrese una fecha válida (YYYY-MM-DD): ");
            fechaPedido = sc.nextLine();
            pedidoTaxi.setFecha(LocalDate.parse(fechaPedido));
        }

        iniciarMenu();

        do {
            try {
                System.out.println("\n------ Opciones ------");
                System.out.println("1. Realizar viaje");
                System.out.println("2. Realizar nuevo viaje");
                System.out.println("3. Mostrar datos del viaje");
                System.out.println("4. Salir");
                System.out.print("Ingrese la opción: ");
                opcion = sc.nextInt();
                sc.nextLine(); // limpiar buffer

                switch (opcion) {
                    case 1:
                        realizarViaje();
                        break;
                    case 2:
                        nuevoViaje();
                        break;
                    case 3:
                        pedidoTaxi.imprimir();
                        break;
                    case 4:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor ingrese un número.");
                sc.nextLine(); // limpiar buffer
            }
        } while (opcion != 4);
    }

    /**
     * Solicita al usuario los datos de un viaje (origen, destino y distancia) y los asigna al pedido actual.
     */
    public void realizarViaje() {
        try {
            System.out.print("Ingrese el origen del viaje: ");
            String origen = sc.nextLine();
            pedidoTaxi.setOrigen(origen);

            System.out.print("Ingrese el destino del viaje: ");
            String destino = sc.nextLine();
            pedidoTaxi.setDestino(destino);

            double distancia;
            do {
                System.out.print("Ingrese la distancia del viaje en km: ");
                distancia = sc.nextDouble();
                sc.nextLine(); // limpiar buffer

                if (distancia <= 0) {
                    System.out.println("La distancia debe ser mayor que 0.");
                } else {
                    pedidoTaxi.setDistancia(distancia);
                }
            } while (distancia <= 0);

        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Asegúrese de ingresar un número válido.");
            sc.nextLine(); // limpiar buffer
        }
    }

    /**
     * Permite al usuario registrar un nuevo viaje con nombre y fecha.
     */
    public void nuevoViaje() {
        System.out.print("Ingrese su nombre: ");
        String nombreCliente = sc.nextLine();

        System.out.print("Ingrese la fecha de su pedido (YYYY-MM-DD): ");
        String fechaPedido = sc.nextLine();

        pedidoTaxi.setNombreCliente(nombreCliente);
        pedidoTaxi.setFecha(LocalDate.parse(fechaPedido));

        while (!pedidoTaxi.programarPedido()) {
            System.out.print("Por favor ingrese una fecha válida (YYYY-MM-DD): ");
            fechaPedido = sc.nextLine();
            pedidoTaxi.setFecha(LocalDate.parse(fechaPedido));
        }
    }
}
