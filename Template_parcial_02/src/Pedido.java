import java.util.List;

public class Pedido extends EntidadBase {
    private List<String> items;

    public Pedido() {}

    public Pedido(String nombre, int id, List<String> items) {
        super(nombre, id);
        this.items = items;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    @Override
    public boolean validar() {
        return items != null && !items.isEmpty();
    }

    @Override
    public void imprimir() {
        System.out.println("Pedido de: " + getNombre());
        for(String item : items){
            System.out.println(" - " + item);
        }
    }
}

