import java.time.LocalDate;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int edad = TryCatchValidaciones.leerEntero(scanner, "Ingrese su edad: ");
        double precio = TryCatchValidaciones.leerDecimal(scanner, "Ingrese el precio: ");
        LocalDate fechaEntrega = TryCatchValidaciones.leerFecha(scanner, "Ingrese la fecha de entrega (yyyy-MM-dd): ");
        String nombre = TryCatchValidaciones.leerTexto(scanner, "Ingrese su nombre: ");

        // Mostrar datos ingresados
        System.out.println("Edad: " + edad);
        System.out.println("Precio: " + precio);
        System.out.println("Fecha: " + fechaEntrega);
        System.out.println("Nombre: " + nombre);
    }

}