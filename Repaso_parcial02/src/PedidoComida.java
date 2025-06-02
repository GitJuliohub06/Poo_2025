import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class PedidoComida extends Pedido {

    private List <Plato> listaPlatos;
    private Map<Plato, Integer> pedidoCliente;

    public PedidoComida() {}

    public PedidoComida(String nombreCliente, LocalDate fecha, int puntos,
                        List<Plato> listaPlatos, Map<Plato, Integer> pedidoCliente) {
        super(nombreCliente, fecha, puntos);
        this.listaPlatos = listaPlatos;
        this.pedidoCliente = pedidoCliente;
    }

    public List<Plato> getListaPlatos() {
        return listaPlatos;
    }

    public void setListaPlatos(List<Plato> listaPlatos) {
        this.listaPlatos = listaPlatos;
    }

    public Map<Plato, Integer> getPedidoCliente() {
        return pedidoCliente;
    }

    public void setPedidoCliente(Map<Plato, Integer> pedidoCliente) {
        this.pedidoCliente = pedidoCliente;
    }

    @Override
    public double calcularTotal() {
        double total = 0;

        for (Map.Entry<Plato, Integer> entry : getPedidoCliente().entrySet()) {
            total += entry.getValue()*entry.getKey().getPrecio();
        }

        if (total<5.99){
            total += 1.99;
        }


        return total;
    }

    @Override
    public int calcularPuntos(){
        int puntosAcumulados = getPuntos();
        int puntos = (int) calcularTotal();
        if (calcularTotal() == 1.99) {
            return 0;
        }
        if (calcularEnvio() >0) {
            puntos -=2;
        }


        puntos = puntos*100;
        puntosAcumulados += puntos;
        setPuntos(puntosAcumulados);

        return puntos;



    }

    public double calcularEnvio(){
        double totalEnvio = 0;

        if (calcularTotal() >= 5.99){
            totalEnvio = 0;
        }else{
            totalEnvio = 1.99;
        }

        return totalEnvio;
    }

    @Override
    public void imprimir(){
        System.out.println("-----Datos del pedido-----");
        System.out.println("Cliente:" + getNombreCliente());
        System.out.println("Fecha:" + getFecha());
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
