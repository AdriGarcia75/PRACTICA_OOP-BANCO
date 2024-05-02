import java.util.Arrays;

public class CuentaBancaria{

    // -- declaracion de atributos final --
    private final String iban;
    private final String titular;
    //booleano para controlar si una cuenta es valida o no, no implementado, pero si no es valida NO se podrá operar con ella
    private final boolean cuentaValida;
    private double saldo;
    private int numMovimientos;
    //una lista, ya que necesitamos registrar cada movimiento que se haga en la cuenta
    private double[] movimientos;

    //-- datos constantes, que se tomaran en cuenta en distintos momentos del codigo
    private final int MAX_MOVIMIENTOS = 100;
    private final double SALDO_MINIMO = -50.0;
    private final double LIMITE_HACIENDA = 3000.0;

    // -- constructor de CuentaBancaria --
    public CuentaBancaria(String iban, String titular){
        this.iban = iban;
        this.titular = titular;
        //si el iban no cumple el formato, o el nombre es algo raro / vacio, no podra utilizarse la cuenta
        if (!iban.matches("^[A-Z]{2}\\d{22}$") && !titular.matches("^\\w{1,20}$")) {
            cuentaValida = false;
            System.err.println("ERROR: el formato del IBAN no es correcto, la cuenta NO podrá usarse");
        } else {
            cuentaValida = true;
            this.saldo = 0;
            this.numMovimientos = 0;
            this.movimientos = new double[MAX_MOVIMIENTOS];
        }
    }

    //-- setters y getters --
    public String getIBAN() {
        return iban;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public double[] getMovimientos() {
        return movimientos;
    }

    //-- metodos más complejos --
    public void ingresarSaldo (double cantidad){
        //solo es un disclaimer
        if (cantidad >= LIMITE_HACIENDA){
            System.out.println("Aviso, esta operación se notificará a hacienda");
        }
        this.saldo += cantidad;
        registrarMovimiento(cantidad);
        System.out.println("Se han añadido " + cantidad + " euros a la cuenta, ahora tienes " + this.saldo);
    }

    //es posible hacer la implementacion de ingreso/retiro a la vez y permitiendo nums negativos -  no necesaria
    /* public void operacion (double cantidad){

    } */

    public void retirarSaldo (double cantidad){
        //podemos tener como limite -50 euros, dicho por el enunciado - si se traspasa, se cancela la operacion
        if (cantidad <= 0){
            System.err.println("Introduce un valor válido, mayor a 0");
        } else {
            if (this.saldo - cantidad >= SALDO_MINIMO){
                if (cantidad >= LIMITE_HACIENDA){
                    System.out.println("Aviso, esta operación se notificará a hacienda");
                }
                this.saldo -= cantidad;
                registrarMovimiento(cantidad);
                System.out.println("Se han añadido " + cantidad + " euros a la cuenta, ahora tienes " + this.saldo);
            } else {
                System.err.println("Saldo insuficiente, no se realizará la operación");
            }
        }
    }

    //WIP - tener en cuenta MAX_MOVIMIENTOS jsjs (100)
    public void registrarMovimiento(double cantidad){
        movimientos[numMovimientos] = cantidad;
        numMovimientos++;
    }

    // -- metodos para enseñar informacion de cada cuenta --
    public void mostrarIBAN() {
        System.out.println("IBAN: " + iban);
    }

    public void mostrarTitular() {
        System.out.println("Titular: " + titular);
    }

    public void mostrarSaldo() {
        System.out.println("Saldo: " + saldo);
    }

    public void mostrarMovimientos() {
        System.out.println("Movimientos: " + numMovimientos);
        for (int i = 0; i < numMovimientos; i++) {
            System.out.println("#" + (i + 1) + ": " + movimientos[i]);
        }
    }
}
