public abstract class EntidadBase implements IEntidad {
    private String nombre;
    private int id;

    public EntidadBase() {}

    public EntidadBase(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public abstract boolean validar();

    @Override
    public abstract void imprimir();
}

