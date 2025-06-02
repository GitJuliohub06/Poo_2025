import java.time.LocalDate;

/**
 * Clase abstracta que representa un pedido general realizado por un cliente.
 *
 * Esta clase proporciona atributos y métodos comunes para todos los tipos de pedidos,
 * como el nombre del cliente, la fecha del pedido y los puntos acumulados.
 * También implementa la interfaz {@link IPedido}.
 */
public abstract class Pedido implements IPedido {

    /** Nombre del cliente que realiza el pedido. */
    private String nombreCliente;

    /** Fecha en la que se realiza o programa el pedido. */
    private LocalDate fecha;

    /** Puntos acumulados del cliente por sus pedidos. */
    private int puntos;

    /** Constructor por defecto. */
    public Pedido() {}

    /**
     * Constructor que inicializa todos los atributos del pedido.
     *
     * @param nombreCliente Nombre del cliente.
     * @param fecha Fecha del pedido.
     * @param puntos Puntos acumulados.
     */
    public Pedido(String nombreCliente, LocalDate fecha, int puntos) {
        this.nombreCliente = nombreCliente;
        this.fecha = fecha;
        this.puntos = puntos;
    }

    /**
     * Obtiene el nombre del cliente.
     *
     * @return Nombre del cliente.
     */
    public String getNombreCliente() {
        return nombreCliente;
    }

    /**
     * Establece el nombre del cliente.
     *
     * @param nombreCliente Nombre del cliente.
     */
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    /**
     * Obtiene la fecha del pedido.
     *
     * @return Fecha del pedido.
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha del pedido.
     *
     * @param fecha Fecha a asignar.
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene los puntos acumulados del pedido.
     *
     * @return Puntos acumulados.
     */
    public int getPuntos() {
        return puntos;
    }

    /**
     * Establece los puntos acumulados del pedido.
     *
     * @param puntos Cantidad de puntos a asignar.
     */
    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    /**
     * Programa el pedido validando que la fecha sea válida.
     * Un pedido es válido si su fecha es hoy o una fecha futura.
     *
     * @return {@code true} si la fecha es válida, {@code false} si es una fecha pasada.
     */
    @Override
    public final boolean programarPedido() {
        LocalDate today = LocalDate.now();
        return fecha != null && (fecha.isAfter(today) || fecha.isEqual(today));
    }

    /**
     * Calcula el total del pedido. Debe ser implementado por las subclases.
     *
     * @return Total a pagar por el pedido.
     */
    @Override
    public abstract double calcularTotal();

    /**
     * Calcula los puntos del pedido. Debe ser implementado por las subclases.
     *
     * @return Puntos obtenidos por el pedido.
     */
    @Override
    public abstract int calcularPuntos();

    /**
     * Imprime la información del pedido. Debe ser implementado por las subclases.
     */
    @Override
    public abstract void imprimir();
}

