File → Settings (o presioná Ctrl + Alt + S)

Editor → General → Code Completion

✅ Show suggestions as you type

✅ Automatically insert single suggestions

✅ Match case: None (para que no sea sensible a mayúsculas)

✅ Sort suggestions alphabetically



USO TRY CATCH 
int numero = 0;
boolean valido = false;

while (!valido) {
    try {
        System.out.print("Ingrese un número: ");
        numero = scanner.nextInt();
        valido = true; // si llega aquí, todo bien
    } catch (InputMismatchException e) {
        System.out.println("Error: Ingrese un número válido.");
        scanner.nextLine(); // limpiar entrada inválida
    }
}
System.out.println("Número ingresado correctamente: " + numero);

