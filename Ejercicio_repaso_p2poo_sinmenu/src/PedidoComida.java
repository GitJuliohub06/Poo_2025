import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * Representa un pedido de comida que contiene una lista de platos y sus cantidades.
 * Extiende la clase abstracta {@link Pedido}.
 */
public class PedidoComida extends Pedido {

    /** Lista de platos disponibles. */
    private List<Plato> listaPlatos;

    /** Mapa que representa el pedido del cliente: Plato y cantidad solicitada. */
    private Map<Plato, Integer> pedidoCliente;

    /** Constructor por defecto. */
    public PedidoComida() {}

    /**
     * Constructor que inicializa todos los atributos del pedido de comida.
     *
     * @param nombreCliente Nombre del cliente.
     * @param fecha Fecha del pedido.
     * @param puntos Puntos acumulados.
     * @param listaPlatos Lista de platos disponibles.
     * @param pedidoCliente Mapa con platos y cantidades pedidas por el cliente.
     */
    public PedidoComida(String nombreCliente, LocalDate fecha, int puntos,
                        List<Plato> listaPlatos, Map<Plato, Integer> pedidoCliente) {
        super(nombreCliente, fecha, puntos);
        this.listaPlatos = listaPlatos;
        this.pedidoCliente = pedidoCliente;
    }

    /**
     * Obtiene la lista de platos disponibles.
     *
     * @return Lista de platos.
     */
    public List<Plato> getListaPlatos() {
        return listaPlatos;
    }

    /**
     * Establece la lista de platos disponibles.
     *
     * @param listaPlatos Nueva lista de platos.
     */
    public void setListaPlatos(List<Plato> listaPlatos) {
        this.listaPlatos = listaPlatos;
    }

    /**
     * Obtiene el mapa del pedido del cliente (platos y cantidades).
     *
     * @return Mapa con los platos y sus cantidades.
     */
    public Map<Plato, Integer> getPedidoCliente() {
        return pedidoCliente;
    }

    /**
     * Establece el mapa del pedido del cliente (platos y cantidades).
     *
     * @param pedidoCliente Nuevo mapa con los platos y cantidades.
     */
    public void setPedidoCliente(Map<Plato, Integer> pedidoCliente) {
        this.pedidoCliente = pedidoCliente;
    }

    /**
     * Calcula el total del pedido sumando el precio de cada plato multiplicado
     * por la cantidad pedida. Si el total es menor que 5.99, se añade un costo
     * de envío de 1.99.
     *
     * @return El total a pagar por el pedido.
     */
    @Override
    public double calcularTotal() {
        double total = 0;

        for (Map.Entry<Plato, Integer> entry : getPedidoCliente().entrySet()) {
            total += entry.getValue() * entry.getKey().getPrecio();
        }

        if (total < 5.99) {
            total += 1.99;
        }

        return total;
    }

    /**
     * Calcula los puntos obtenidos por el pedido basándose en el total del pedido,
     * restando puntos si hay costo de envío y multiplicando por 100.
     *
     * @return Los puntos obtenidos en este pedido.
     */
    @Override
    public int calcularPuntos() {
        int puntosAcumulados = getPuntos();
        int puntos = (int) calcularTotal();

        if (calcularTotal() == 1.99) {
            return 0;
        }
        if (calcularEnvio() > 0) {
            puntos -= 2;
        }

        puntos *= 100;
        puntosAcumulados += puntos;
        setPuntos(puntosAcumulados);

        return puntos;
    }

    /**
     * Calcula el costo de envío basado en el total del pedido.
     * Si el total es mayor o igual a 5.99, el envío es gratis.
     *
     * @return Costo del envío.
     */
    public double calcularEnvio() {
        if (calcularTotal() >= 5.99) {
            return 0;
        } else {
            return 1.99;
        }
    }

    /**
     * Imprime en consola los datos completos del pedido, incluyendo cliente,
     * fecha, platos pedidos con sus cantidades, costo de envío, total y puntos.
     */
    @Override
    public void imprimir() {
        System.out.println("-----Datos del pedido-----");
        System.out.println("Cliente: " + getNombreCliente());
        System.out.println("Fecha: " + getFecha());
        System.out.println("Pedido:");
        for (Map.Entry<Plato, Integer> entry : getPedidoCliente().entrySet()) {
            entry.getKey().imprimirPlato();
            System.out.println(" - cantidad: " + entry.getValue());
        }
        System.out.println("Envio: " + calcularEnvio());
        System.out.println("Total: " + calcularTotal());
        System.out.println("Puntos obtenidos : " + calcularPuntos());
        System.out.println("Puntos acumulados  : " + getPuntos());
    }

}
