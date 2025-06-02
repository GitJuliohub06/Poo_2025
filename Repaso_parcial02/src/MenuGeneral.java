import java.util.Scanner;

/**
 * Clase que representa el menú general de una aplicación de pedidos.
 * Permite al usuario elegir entre pedir comida, solicitar un viaje o salir del programa.
 *
 * <p>Este menú se ejecuta en un bucle hasta que el usuario elige la opción de salir (opción 3).</p>
 */
public class MenuGeneral {

    /**
     * Objeto Scanner para la entrada de datos desde la consola.
     */
    Scanner sc = new Scanner(System.in);

    /**
     * Muestra el menú general y permite al usuario seleccionar una opción.
     *
     * <p>Las opciones disponibles son:</p>
     * <ul>
     *   <li>1 - Pedir comida</li>
     *   <li>2 - Pedir un viaje</li>
     *   <li>3 - Salir</li>
     * </ul>
     *
     * <p>El método maneja excepciones en caso de errores de entrada.</p>
     */
    public void menu() {
        int opcion = 0;
        do {
            try {
                System.out.println("-------Menu General (Parcial 02)------");
                System.out.println("1. Pedir comida");
                System.out.println("2. Pedir un viaje");
                System.out.println("3. Salir");
                System.out.print("Ingrese su opcion: ");
                opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {
                    case 1:
                        MenuPedidoComida menu = new MenuPedidoComida(new PedidoComida());
                        menu.menuPedidoComida();
                        break;

                    case 2:
                        MenuPedidoTaxi menuPedidoTaxi = new MenuPedidoTaxi(new PedidoTaxi());
                        menuPedidoTaxi.menuPedidoTaxi();
                        break;

                    case 3:
                        System.out.println("Saliendo del programa....");
                        break;

                    default:
                        System.out.println("Opcion no valida");
                }
            } catch (Exception e) {
                System.out.println("Codigo de error: " + e.getMessage());
            }

        } while (opcion != 3);
    }
}
