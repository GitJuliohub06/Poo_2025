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
        double total = 0.0;

        try {
            double distancia = getDistancia();

            if (distancia < 0) {
                throw new IllegalArgumentException("La distancia no puede ser negativa.");
            }

            total = distancia * 1.50;

        } catch (Exception e) {
            System.out.println("Error al calcular el total del viaje: " + e.getMessage());
        }

        return total;
    }

    /**
     * Calcula los puntos obtenidos por el viaje y actualiza los puntos acumulados.
     * Cada kilómetro equivale a 2 puntos.
     *
     * @return Puntos ganados en este viaje.
     */
    @Override
    public int calcularPuntos() {
        int puntosAcumulados = getPuntos();
        int puntos = 0;

        try {
            double distancia = getDistancia();

            if (distancia < 0) {
                throw new IllegalArgumentException("La distancia no puede ser negativa.");
            }

            puntos = (int) distancia * 2;
            puntosAcumulados += puntos;
            setPuntos(puntosAcumulados);

        } catch (Exception e) {
            System.out.println("Error al calcular puntos del viaje: " + e.getMessage());
        }

        return puntos;
    }

    /**
     * Imprime los detalles del viaje, incluyendo origen, destino, distancia,
     * total a pagar, puntos obtenidos y puntos acumulados.
     */
    @Override
    public void imprimir() {
        try {
            System.out.println("------ Datos del viaje ------");

            String origen = getOrigen();
            String destino = getDestino();
            double distancia = getDistancia();

            if (origen == null || destino == null) {
                throw new NullPointerException("Origen o destino no pueden ser nulos.");
            }

            if (distancia < 0) {
                throw new IllegalArgumentException("La distancia no puede ser negativa.");
            }

            System.out.println("Origen: " + origen);
            System.out.println("Destino: " + destino);
            System.out.println("Distancia: " + distancia + " km");
            System.out.println("Total: $" + calcularTotal());
            System.out.println("Puntos Obtenidos: " + calcularPuntos());
            System.out.println("Puntos Acumulados: " + getPuntos());
            System.out.println("------ ¡Muchas gracias por su viaje! :) ------");

        } catch (Exception e) {
            System.out.println("Error al imprimir los datos del viaje: " + e.getMessage());
        }
    }
}
