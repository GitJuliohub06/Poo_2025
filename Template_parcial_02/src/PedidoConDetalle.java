import java.util.Map;

public class PedidoConDetalle {
    private Map<String, Integer> productos; // producto y cantidad

    public PedidoConDetalle() {}

    public PedidoConDetalle(Map<String, Integer> productos) {
        this.productos = productos;
    }

    public Map<String, Integer> getProductos() {
        return productos;
    }

    public void setProductos(Map<String, Integer> productos) {
        this.productos = productos;
    }

    public double calcularTotal(Map<String, Double> precios) {
        double total = 0;
        for (Map.Entry<String, Integer> entry : productos.entrySet()) {
            total += precios.get(entry.getKey()) * entry.getValue();
        }
        return total;
    }
}

