import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * Representa un pedido de comida que contiene una lista de platos y sus cantidades.
 * Extiende la clase abstracta {@link Pedido}.
 */
public class PedidoComida extends Pedido {

    /**
     * Lista de platos disponibles.
     */
    private List<Plato> listaPlatos;

    /**
     * Mapa que representa el pedido del cliente: Plato y cantidad solicitada.
     */
    private Map<Plato, Integer> pedidoCliente;

    /**
     * Constructor por defecto.
     */
    public PedidoComida() {
    }

    /**
     * Constructor que inicializa todos los atributos del pedido de comida.
     *
     * @param nombreCliente Nombre del cliente.
     * @param fecha         Fecha del pedido.
     * @param puntos        Puntos acumulados.
     * @param listaPlatos   Lista de platos disponibles.
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

    /**
     * Calcula el total del pedido sumando el precio de cada plato multiplicado
     * por la cantidad pedida. Si el total es menor que 5.99, se añade un costo
     * de envío de 1.99.
     *
     * @return El total a pagar por el pedido.
     */

    @Override
    public double calcularTotal() {
        double total = 0.0;

        try {
            Map<Plato, Integer> pedido = getPedidoCliente();

            if (pedido == null || pedido.isEmpty()) {
                throw new IllegalStateException("No hay platos en el pedido.");
            }

            for (Map.Entry<Plato, Integer> entry : pedido.entrySet()) {
                Plato plato = entry.getKey();
                Integer cantidad = entry.getValue();

                if (plato == null || cantidad == null || cantidad < 0 || plato.getPrecio() < 0) {
                    throw new IllegalArgumentException("Datos inválidos en el pedido.");
                }

                total += cantidad * plato.getPrecio();
            }

            if (total < 5.99) {
                total += 1.99; // Cargo por envío
            }

        } catch (Exception e) {
            System.out.println("Error al calcular el total: " + e.getMessage());
        }

        return total;
    }

    /**
     * Calcula los puntos obtenidos por el pedido basándose en el total del pedido,
     * restando puntos si hay costo de envío y multiplicando por 100.
     *
     * @return Los puntos obtenidos en este pedido.
     */

    public double calcularEnvio() {
        double envio = 0.0;

        try {
            double total = calcularTotal();

            if (total < 0) {
                throw new IllegalStateException("Total inválido al calcular envío.");
            }

            envio = (total >= 5.99) ? 0.0 : 1.99;

        } catch (Exception e) {
            System.out.println("Error al calcular el envío: " + e.getMessage());
        }

        return envio;
    }


    /**
     * Calcula el costo de envío basado en el total del pedido.
     * Si el total es mayor o igual a 5.99, el envío es gratis.
     *
     * @return Costo del envío.
     */
    @Override
    public int calcularPuntos() {
        int puntosAcumulados = getPuntos();
        int puntos = 0;

        try {
            double total = calcularTotal();
            double envio = calcularEnvio();

            if (total <= 0) {
                throw new IllegalArgumentException("El total calculado no es válido.");
            }

            if (total == 1.99) {
                return 0;
            }

            puntos = (int) total;

            if (envio > 0) {
                puntos -= 2;
            }

            puntos *= 100;

            if (puntos < 0) {
                puntos = 0;
            }

            puntosAcumulados += puntos;
            setPuntos(puntosAcumulados);

        } catch (Exception e) {
            System.out.println("Error al calcular puntos: " + e.getMessage());
        }

        return puntos;
    }
}
