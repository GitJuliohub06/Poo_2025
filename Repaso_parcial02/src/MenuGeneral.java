import java.util.Scanner;

public class MenuGeneral {
    Scanner sc = new Scanner(System.in);
    public void menu() {
        int opcion = 0;
        do {
            try{
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
            }catch(Exception e){
                System.out.println("Codigo de error: " + e.getMessage());
            }

        }while (opcion != 3);

    }

}
