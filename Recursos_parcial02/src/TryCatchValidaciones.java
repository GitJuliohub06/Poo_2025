import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * Clase encargada del manejo de validaciones en la entrada de datos
 */
public class TryCatchValidaciones {

    /**
     *
     * @param scanner
     * @param mensaje
     * @return numero ingresado por el usuario si es valido
     */
    public static int leerEntero(Scanner scanner, String mensaje) {
        int numero = 0;
        boolean valido = false;

        while (!valido) {
            try {
                System.out.print(mensaje);
                numero = scanner.nextInt();
                valido = true;
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un número entero válido.");
                scanner.nextLine(); // Limpiar entrada inválida
            }
        }
        return numero;
    }


    /**
     *
     * @param scanner
     * @param mensaje
     * @return decimal ingresado por el usuario si es valido
     */
    public static double leerDecimal(Scanner scanner, String mensaje) {
        double numero = 0.0;
        boolean valido = false;

        while (!valido) {
            try {
                System.out.print(mensaje);
                numero = scanner.nextDouble();
                valido = true;
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un número decimal válido.");
                scanner.nextLine(); // Limpiar entrada inválida
            }
        }
        return numero;
    }

    /**
     *
     * @param scanner
     * @param mensaje
     * @return fecha ingresada por el usuario en formato string transformada a LocalDate
     */
    public static LocalDate leerFecha(Scanner scanner, String mensaje) {
        LocalDate fecha = null;
        boolean valido = false;

        while (!valido) {
            try {
                System.out.print(mensaje);
                String entrada = scanner.nextLine();
                fecha = LocalDate.parse(entrada);
                valido = true;
            } catch (DateTimeParseException e) {
                System.out.println("Error: Formato incorrecto. Use yyyy-MM-dd.");
            }
        }
        return fecha;
    }

    /**
     *
     * @param scanner
     * @param mensaje
     * @return texto ingresado por el usuario (no campo vacio)
     */
    public static String leerTexto(Scanner scanner, String mensaje) {
        String texto = "";
        boolean valido = false;

        while (!valido) {
            System.out.print(mensaje);
            texto = scanner.nextLine();
            if (!texto.trim().isEmpty()) {
                valido = true;
            } else {
                System.out.println("Error: El texto no puede estar vacío.");
            }
        }
        return texto;
    }


}
