import java.time.LocalDate;

public abstract class Pedido implements IPedido {

    private String nombreCliente;
    private LocalDate fecha;
    private int puntos;

    public Pedido() {}

    public Pedido(String nombreCliente, LocalDate fecha, int puntos) {
        this.nombreCliente = nombreCliente;
        this.fecha = fecha;
        this.puntos = puntos;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public final boolean programarPedido() {

        LocalDate today = LocalDate.now();

        if (getFecha().isAfter(today) || getFecha().isEqual(today)) {
            return true;
        } else {
            return false;
        }
    }

    public abstract double calcularTotal();

    public abstract int calcularPuntos();

    public abstract void imprimir();


}
