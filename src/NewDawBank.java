import java.util.Scanner;

public class NewDawBank{

    public static void main(String[] args) {
        //declaramos scanner
        Scanner sc = new Scanner(System.in);

        //creamos el objeto / la cuenta bancaria
        CuentaBancaria cuentaPrueba = new CuentaBancaria("ES7921000813610123456789", "Nathan");
        //invocamos al menu
        displayMenu();
        boolean programaActivo = true;
        //el bucle para manetener la aplicacion activa
        while (programaActivo){
            //utilizamos una variable para controlar la eleccion del usuario
            int eleccionUsuario = sc.nextInt();
            //codigo que llama a distintas funciones de la clase Cuenta BaNncria
            switch(eleccionUsuario){
                case 1 -> {
                    cuentaPrueba.mostrarIBAN();
                    cuentaPrueba.getTitular();
                    cuentaPrueba.getSaldo();
                }
                case 2 -> {
                    cuentaPrueba.mostrarIBAN();
                }
                case 3 -> {
                    cuentaPrueba.getTitular();
                }
                case 4 -> {
                    cuentaPrueba.getSaldo();
                }
                case 5 -> {
                    System.out.println("Introduce una cantidad a ingresar");
                    double cantidad = sc.nextDouble();
                    cuentaPrueba.ingresarSaldo(cantidad);
                }
                case 6 -> {
                    System.out.println("Introduce una cantidad a ingresar");
                    double cantidad = sc.nextDouble();
                    cuentaPrueba.retirarSaldo(cantidad);
                }
                case 7 -> {
                    cuentaPrueba.mostrarMovimientos();
                }
                case 8 -> {
                    programaActivo = false;
                }
                default -> {
                    System.err.println("ERROR - Opción invalida");
                }
            }
            //volvemos a enseñar el menu
            displayMenu();
        }
    }
    public static void displayMenu(){
        System.out.println("1. Datos de la cuenta. Mostrará el IBAN, el titular y el saldo.");
        System.out.println("2. IBAN. Mostrará el IBAN.");
        System.out.println("3. Titular. Mostrará el titular.");
        System.out.println("4. Saldo. Mostrará el saldo disponible.");
        System.out.println("5. Ingreso. Pedirá la cantidad a ingresar y realizará el ingreso si es posible.");
        System.out.println("6. Retirada. Pedirá la cantidad a retirar y realizará la retirada si es posible.");
        System.out.println("7. Movimientos. Mostrará una lista con el historial de movimientos.");
        System.out.println("8. Salir. Terminar el programa");
    }
}