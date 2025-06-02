import java.time.LocalDate;

/**
 * Clase que representa un pedido específico de taxi.
 * Hereda de la clase base {@link Pedido} e incluye detalles del viaje como
 * origen, destino y distancia. Calcula el total y los puntos obtenidos.
 */
public class PedidoTaxi extends Pedido {

    private String origen;
    private String destino;
    private double distancia;

    /**
     * Constructor por defecto.
     */
    public PedidoTaxi() {
    }

    /**
     * Constructor con parámetros para inicializar todos los atributos.
     *
     * @param nombreCliente Nombre del cliente.
     * @param fecha         Fecha del pedido.
     * @param puntos        Puntos acumulados (se puede iniciar en 0).
     * @param origen        Punto de partida del viaje.
     * @param destino       Punto de destino del viaje.
     * @param distancia     Distancia del viaje en kilómetros.
     */
    public PedidoTaxi(String nombreCliente, LocalDate fecha, int puntos,
                      String origen, String destino, double distancia) {
        super(nombreCliente, fecha, puntos);
        this.origen = origen;
        this.destino = destino;
        this.distancia = distancia;
    }

    /**
     * Obtiene el origen del viaje.
     *
     * @return Cadena con el origen.
     */
    public String getOrigen() {
        return origen;
    }

    /**
     * Establece el origen del viaje.
     *
     * @param origen Cadena con el origen.
     */
    public void setOrigen(String origen) {
        this.origen = origen;
    }

    /**
     * Obtiene el destino del viaje.
     *
     * @return Cadena con el destino.
     */
    public String getDestino() {
        return destino;
    }

    /**
     * Establece el destino del viaje.
     *
     * @param destino Cadena con el destino.
     */
    public void setDestino(String destino) {
        this.destino = destino;
    }

    /**
     * Obtiene la distancia del viaje.
     *
     * @return Distancia en kilómetros.
     */
    public double getDistancia() {
        return distancia;
    }

    /**
     * Establece la distancia del viaje.
     *
     * @param distancia Distancia en kilómetros.
     */
    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    /**
     * Calcula el total a pagar por el viaje en base a la distancia.
     *
     * @return Total en dólares.
     */
    @Override
    public double calcularTotal() {
        return getDistancia() * 1.50;
    }

    /**
     * Calcula los puntos obtenidos por el viaje y actualiza los puntos acumulados.
     * Cada kilómetro equivale a 2 puntos.
     *
     * @return Puntos ganados en este viaje.
     */
    @Override
    public int calcularPuntos() {
        int puntos = ((int) getDistancia()) * 2;
        setPuntos(puntos);
        return puntos;
    }

    /**
     * Imprime los detalles del viaje, incluyendo origen, destino, distancia,
     * total a pagar, puntos obtenidos y puntos acumulados.
     */
    @Override
    public void imprimir() {
        System.out.println("------ Datos del viaje ------");
        System.out.println("Origen: " + getOrigen());
        System.out.println("Destino: " + getDestino());
        System.out.println("Distancia: " + getDistancia() + " km");
        System.out.println("Total: $" + calcularTotal());
        System.out.println("Puntos Obtenidos: " + calcularPuntos());
        System.out.println("Puntos Acumulados: " + getPuntos());
        System.out.println("------ ¡Muchas gracias por su viaje! :) ------");
    }
}
