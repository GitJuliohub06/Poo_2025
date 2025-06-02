public class Plato {

    private String restaurante;
    private String nombre;
    private double precio;

    public Plato(){}

    public Plato(String restaurante, String nombre, double precio) {
        this.restaurante = restaurante;
        this.nombre = nombre;
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(String restaurante) {
        this.restaurante = restaurante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void imprimirPlato() {
        System.out.println("Restaurante: " + getRestaurante());
        System.out.print(" - Plato: " + getNombre());
        System.out.print(" - Precio: " + getPrecio());

    }


}
