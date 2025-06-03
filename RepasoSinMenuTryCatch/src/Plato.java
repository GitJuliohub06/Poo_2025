/**
 * Clase que representa un plato ofrecido por un restaurante.
 *
 * Contiene la información del restaurante, el nombre del plato y su precio.
 */
public class Plato {

    /** Nombre del restaurante que ofrece el plato. */
    private String restaurante;

    /** Nombre del plato. */
    private String nombre;

    /** Precio del plato. */
    private double precio;

    /** Constructor por defecto. */
    public Plato() {}

    /**
     * Constructor que inicializa todos los atributos del plato.
     *
     * @param restaurante Nombre del restaurante.
     * @param nombre Nombre del plato.
     * @param precio Precio del plato.
     */
    public Plato(String restaurante, String nombre, double precio) {
        this.restaurante = restaurante;
        this.nombre = nombre;
        this.precio = precio;
    }

    /**
     * Obtiene el precio del plato.
     *
     * @return Precio del plato.
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del plato.
     *
     * @param precio Nuevo precio del plato.
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Obtiene el nombre del restaurante.
     *
     * @return Nombre del restaurante.
     */
    public String getRestaurante() {
        return restaurante;
    }

    /**
     * Establece el nombre del restaurante.
     *
     * @param restaurante Nuevo nombre del restaurante.
     */
    public void setRestaurante(String restaurante) {
        this.restaurante = restaurante;
    }

    /**
     * Obtiene el nombre del plato.
     *
     * @return Nombre del plato.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del plato.
     *
     * @param nombre Nuevo nombre del plato.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Imprime la información del plato en consola.
     */
    public void imprimirPlato() {
        System.out.println(" Restaurante: " + getRestaurante());
        System.out.print(" - Plato: " + getNombre());
        System.out.println(" - Precio: " + getPrecio());
    }
}