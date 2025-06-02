import java.time.LocalDate;
import java.util.*;

public class MenuPedidoComida {

    Scanner sc = new Scanner(System.in);

    private PedidoComida pedidoComida;

    public MenuPedidoComida(PedidoComida pedidoComida) {
        this.pedidoComida = pedidoComida;
    }

    public void agregarPlatos() {
        Plato plato = new Plato("Wendys", "Baconator", 8.99); //plato 1.
        Plato plato2 = new Plato("Pizza Hut", "Mybox", 5.99); //plato 2.
        Plato plato3 = new Plato("Tacos Lips", "Tacos pierna", 1.25); //plato 3.
        List<Plato> platos = new ArrayList<Plato>();
        platos.add(plato);
        platos.add(plato2);
        platos.add(plato3);

        pedidoComida.setListaPlatos(platos);
    }

    public void mostrarMenu() {
        System.out.println("------Menu del restaurante:------");
        int i = 1;
        for (Plato menu : pedidoComida.getListaPlatos()) {

            System.out.println(i + ". " + menu.getNombre() + " --- " + menu.getPrecio() + " --- " + menu.getRestaurante());
            i++;
        }
    }

    public void iniciarMenu() {
        agregarPlatos();
        Map<Plato, Integer> pedidoCliente = new HashMap<>();
        pedidoComida.setPedidoCliente(pedidoCliente);

        mostrarMenu();

    }


    public void menuPedidoComida() {
        int opcion = 0;
        String nombreCliente = "";
        String fechaPedido = "";

        System.out.println("Ingrese su nombre:");
        nombreCliente = sc.nextLine();
        System.out.println("Ingrese la fecha de su pedido (YYYY-MM-DD):");
        fechaPedido = sc.nextLine();

        pedidoComida.setNombreCliente(nombreCliente);
        pedidoComida.setFecha(LocalDate.parse(fechaPedido));
        while (!pedidoComida.programarPedido()) {
            System.out.println("Por favor ingrese una fecha valida (YYYY-MM-DD):");
            fechaPedido = sc.nextLine();
            pedidoComida.setFecha(LocalDate.parse(fechaPedido));

        }


        iniciarMenu();
        do {

            try {


                System.out.println("------Opciones:------");
                System.out.println("1. Agregar plato al pedido");
                System.out.println("2. Eliminar plato del pedido");
                System.out.println("3. Mostrar pedido");
                System.out.println("4. Realizar un nuevo pedido");
                System.out.println("5. Salir");
                System.out.print("Ingrese la opcion: ");
                opcion = sc.nextInt();
                sc.nextLine();
                switch (opcion) {
                    case 1:
                        agregarPLato();
                        break;
                    case 2:
                        eliminarPlato();
                        break;
                    case 3:
                        pedidoComida.imprimir();
                        break;
                    case 4:
                        nuevoPedido();
                        break;

                    case 5:
                        System.out.println("Saliendo del programa........");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor ingrese un número.");
                sc.nextLine();
            }

        } while (opcion != 5);


    }

    public void agregarPLato() {
        mostrarMenu();
        String nombre = "";
        int cantidad = 0;

        try {
            System.out.println("Ingrese el nombre del plato: ");
            nombre = sc.nextLine();

            do {
                System.out.println("Ingrese la cantidad de platos que desea agregar: ");
                cantidad = sc.nextInt();
                if (cantidad <= 0) {
                    System.out.println("El cantidad debe ser mayor que 0");
                }
            } while (cantidad <= 0);

            sc.nextLine(); // limpiar el buffer después de nextInt

            Map<Plato, Integer> pedido = pedidoComida.getPedidoCliente();

            boolean platoEncontrado = false;
            for (Plato plato : pedidoComida.getListaPlatos()) {
                if (nombre.equalsIgnoreCase(plato.getNombre())) {
                    pedido.put(plato, cantidad);
                    platoEncontrado = true;
                    break;
                }
            }

            if (!platoEncontrado) {
                System.out.println("Plato no encontrado en el menú.");
            }

            pedidoComida.setPedidoCliente(pedido);

        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Asegúrese de ingresar un número entero para la cantidad.");
            sc.nextLine(); // limpiar el buffer si ocurrió un error
        }
    }


    public void eliminarPlato() {
        String nombre = "";
        pedidoComida.imprimir();
        Map<Plato, Integer> pedidoClienteRespaldo = pedidoComida.getPedidoCliente();

        try {
            System.out.println("Ingrese el nombre del plato que desea eliminar: ");
            nombre = sc.nextLine();

            boolean eliminado = false;

            Iterator<Map.Entry<Plato, Integer>> iterador = pedidoClienteRespaldo.entrySet().iterator();
            while (iterador.hasNext()) {
                Map.Entry<Plato, Integer> entry = iterador.next();
                if (nombre.equalsIgnoreCase(entry.getKey().getNombre())) {
                    iterador.remove();
                    eliminado = true;
                    break;
                }
            }

            if (eliminado) {
                System.out.println("Plato eliminado exitosamente.");
            } else {
                System.out.println("El plato no se encontró en el pedido.");
            }

            pedidoComida.setPedidoCliente(pedidoClienteRespaldo);

        } catch (Exception e) {
            System.out.println("Ocurrió un error al intentar eliminar el plato.");
        }
    }

    public void nuevoPedido() {
        System.out.println("Ingrese su nombre:");
        String nombreCliente = sc.nextLine();

        System.out.println("Ingrese la fecha de su pedido (YYYY-MM-DD):");
        String fechaPedido = sc.nextLine();

        pedidoComida.setNombreCliente(nombreCliente);
        pedidoComida.setFecha(LocalDate.parse(fechaPedido));

        while (!pedidoComida.programarPedido()) {
            System.out.println("Por favor ingrese una fecha válida (YYYY-MM-DD):");
            fechaPedido = sc.nextLine();
            pedidoComida.setFecha(LocalDate.parse(fechaPedido));
        }


        Map<Plato, Integer> pedidoCliente = new HashMap<>();
        pedidoComida.setPedidoCliente(pedidoCliente);
        pedidoComida.setPuntos(0);
    }




}
