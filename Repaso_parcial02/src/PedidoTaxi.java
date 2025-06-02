import java.time.LocalDate;

public class PedidoTaxi  extends Pedido{
    private String origen;
    private String destino;
    private double distancia;

    public PedidoTaxi(){}

    public PedidoTaxi(String nombreCliente, LocalDate fecha, int puntos, String origen, String destino, double distancia) {
        super(nombreCliente, fecha, puntos);
        this.origen = origen;
        this.destino = destino;
        this.distancia = distancia;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }
    @Override
    public double calcularTotal() {

        double total = 0;

        total = getDistancia() * 1.50;

        return total;

    }

    @Override
    public int calcularPuntos() {

        int puntosAcumulados = 0;
        int puntos = ((int) getDistancia())*2;

        puntosAcumulados += puntos;
        setPuntos(puntosAcumulados);
        return puntos;
    }

    @Override
    public void imprimir() {
        System.out.println("------Datos del viaje------");
        System.out.println("Origen: " + getOrigen());
        System.out.println("Destino: " + getDestino());
        System.out.println("Distancia: " + getDistancia());
        System.out.println("Total: " + calcularTotal());
        System.out.println("Puntos Obtenidos: " + calcularPuntos());
        System.out.println("Puntos Acumulados: " + getPuntos());
        System.out.println("------Muchas gracias por su viaje :)------");
    }


}
