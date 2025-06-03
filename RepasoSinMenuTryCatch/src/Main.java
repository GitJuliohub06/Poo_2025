import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        /**
         * Se comprueba el funcionamiento de las clase {@link PedidoTaxi}
         */

        PedidoTaxi pedidoTaxi = new PedidoTaxi();
        pedidoTaxi.setNombreCliente("Pedi");
        pedidoTaxi.setFecha(LocalDate.parse("2025-06-07"));
        pedidoTaxi.setOrigen("soyapango");
        pedidoTaxi.setDestino("apopa");
        pedidoTaxi.setDistancia(100);
        System.out.println("----------Datos del pedido de taxi----------");
        pedidoTaxi.imprimir();
        System.out.println("----------Datos para comprobar el almacenamiento de puntos en pedido de taxi----------");
        pedidoTaxi.setOrigen("aguilares");
        pedidoTaxi.setDestino("la union");
        pedidoTaxi.setDistancia(1000);
        pedidoTaxi.imprimir();

        PedidoComida pedidoComida = new PedidoComida();

        List <Plato> listaPlatos = new ArrayList<Plato>();
        Plato plato1 = new Plato("Wendys", "baconator", 8.99);
        Plato plato2 = new Plato("Pizza hut", "Mybox", 5.99);
        Plato plato3 = new Plato("Wok Expres", "Combo cerdo", 2.50);

        Map <Plato, Integer> pedidoCliente = new HashMap<Plato, Integer>();

        pedidoCliente.put(plato1, 1);
        pedidoCliente.put(plato2, 2);
        pedidoCliente.put(plato3, 3);
        listaPlatos.add(plato1);
        listaPlatos.add(plato2);
        listaPlatos.add(plato3);

        pedidoComida.setListaPlatos(listaPlatos);
        pedidoComida.setPedidoCliente(pedidoCliente);

        System.out.println("---menu---");
        for (Plato plato : pedidoComida.getListaPlatos()) {
            plato.imprimirPlato();
        }

        pedidoComida.setNombreCliente("Pedriol");
        pedidoComida.setFecha(LocalDate.parse("2025-08-07"));
        System.out.println("----------Datos del pedido de comida----------");
        pedidoComida.imprimir();

        PedidoComida pedidoComida2 = new PedidoComida();

        Map <Plato, Integer> pedidoCliente2 = new HashMap<Plato, Integer>();

        pedidoCliente2.put(plato3, 1);

        pedidoComida2.setListaPlatos(listaPlatos);
        pedidoComida2.setPedidoCliente(pedidoCliente2);
        pedidoComida2.setNombreCliente("Jaramillo");
        pedidoComida2.setFecha(LocalDate.parse("2025-08-07"));
        System.out.println("----------Datos del pedido de comida comprobando el cobro de envio----------");
        pedidoComida2.imprimir();


    }
}