/**
 * Interfaz que define el comportamiento general de un pedido.
 *
 * Las clases que implementen esta interfaz deberán proporcionar
 * la lógica para programar un pedido, calcular el total a pagar,
 * calcular los puntos obtenidos y mostrar los datos del pedido.
 */
public interface IPedido {

    /**
     * Programa el pedido verificando condiciones necesarias como
     * la validez de la fecha u otros criterios de negocio.
     *
     * @return {@code true} si el pedido fue programado correctamente,
     *         {@code false} en caso contrario.
     */
    boolean programarPedido();

    /**
     * Calcula el total a pagar por el pedido.
     *
     * @return Monto total en dólares u otra unidad monetaria.
     */
    double calcularTotal();

    /**
     * Calcula los puntos obtenidos por el pedido según las reglas
     * definidas en la implementación.
     *
     * @return Cantidad de puntos obtenidos.
     */
    int calcularPuntos();

    /**
     * Muestra por consola los datos relevantes del pedido.
     * Esto puede incluir origen, destino, monto, puntos, etc.
     */
    void imprimir();
}