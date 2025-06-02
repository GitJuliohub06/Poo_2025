import java.time.LocalDate;
import java.util.*;

public class MenuPedidoTaxi {


        Scanner sc = new Scanner(System.in);

        private PedidoTaxi pedidoTaxi;

        public MenuPedidoTaxi() {}

        public MenuPedidoTaxi(PedidoTaxi pedidoTaxi) {
            this.pedidoTaxi = pedidoTaxi;
        }

        public PedidoTaxi getPedidoTaxi() {
            return pedidoTaxi;
        }

        public void setPedidoTaxi(PedidoTaxi pedidoTaxi) {
            this.pedidoTaxi = pedidoTaxi;
        }



        public void iniciarMenu() {


        }


        public void menuPedidoTaxi() {
            int opcion = 0;
            String nombreCliente = "";
            String fechaPedido = "";

            System.out.println("Ingrese su nombre:");
            nombreCliente = sc.nextLine();
            System.out.println("Ingrese la fecha de su pedido (YYYY-MM-DD):");
            fechaPedido = sc.nextLine();

            pedidoTaxi.setNombreCliente(nombreCliente);
            pedidoTaxi.setFecha(LocalDate.parse(fechaPedido));
            while (!pedidoTaxi.programarPedido()) {
                System.out.println("Por favor ingrese una fecha valida (YYYY-MM-DD):");
                fechaPedido = sc.nextLine();
                pedidoTaxi.setFecha(LocalDate.parse(fechaPedido));

            }


            iniciarMenu();
            do {

                try {


                    System.out.println("------Opciones:------");
                    System.out.println("1. Realizar viaje");
                    System.out.println("2. Realizar nuevo viaje");
                    System.out.println("3. Mostrar datos del viaje");
                    System.out.println("4. Salir");
                    System.out.print("Ingrese la opcion: ");
                    opcion = sc.nextInt();
                    sc.nextLine();
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
                            System.out.println("Saliendo del programa........");
                            break;

                        default:
                            System.out.println("Opción no válida.");
                    }

                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Por favor ingrese un número.");
                    sc.nextLine();
                }

            } while (opcion != 4);


        }

        public void realizarViaje() {

            String origen = "";
            String destino = "";
            double distancia = 0;

            try {
                System.out.println("Ingrese el origen del viaje: ");
                origen = sc.nextLine();
                pedidoTaxi.setOrigen(origen);
                System.out.println("Ingrese el origen destino del viaje: ");
                destino = sc.nextLine();
                pedidoTaxi.setDestino(destino);
                sc.nextLine();
                do {
                    System.out.println("Ingrese la distancia del viaje: ");
                    distancia = sc.nextInt();
                    if (distancia <= 0) {
                        System.out.println("El cantidad debe ser mayor que 0");
                    }else{
                        pedidoTaxi.setDistancia(distancia);
                        sc.nextLine();
                    }
                } while (distancia <= 0);




            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Asegúrese de ingresar un número entero para la cantidad.");
                sc.nextLine();
            }
        }


        public void nuevoViaje() {
            System.out.println("Ingrese su nombre:");
            String nombreCliente = sc.nextLine();

            System.out.println("Ingrese la fecha de su pedido (YYYY-MM-DD):");
            String fechaPedido = sc.nextLine();

            pedidoTaxi.setNombreCliente(nombreCliente);
            pedidoTaxi.setFecha(LocalDate.parse(fechaPedido));

            while (!pedidoTaxi.programarPedido()) {
                System.out.println("Por favor ingrese una fecha válida (YYYY-MM-DD):");
                fechaPedido = sc.nextLine();
                pedidoTaxi.setFecha(LocalDate.parse(fechaPedido));
            }

        }




    }


