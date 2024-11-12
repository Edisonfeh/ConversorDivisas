
import java.util.Scanner;

public class Menu {

    Scanner scanner = new Scanner(System.in);
    BusquedaConversor buscarMoneda = new BusquedaConversor();

    public void mostrarMenu() {
        System.out.println("BIENVENIDO A SU CONVERSOR DE MONEDA");





        System.out.println("*********************************************" + "\n");

        System.out.println("siglas de su moneda" + "\n");
        System.out.println("""
                ARS - Peso argentino
                
                BOB - Boliviano boliviano
                
                BRL - Real brasileño
                
                CLP - Peso chileno
                
                COP - Peso colombiano
                
                USD - Dólar estadounidense""");
        System.out.println("*********************************************" + "\n");



                System.out.println("Introduce la moneda de origen ejemplo (USD)");

                String moneda_base = scanner.nextLine().trim().toUpperCase();

                System.out.println("Introduce la moneda de destino");
                String moneda_destino = scanner.nextLine().trim().toUpperCase();

                System.out.println("Introduce el monto a convertir: ");
                double valor = scanner.nextDouble();
                scanner.nextLine();

                //Conversion de la moneda multiplicando el resultado de la conversion con el valor ingresado
                double valorConversion = buscarMoneda.convertirMoneda(moneda_base, moneda_destino);
                double resultadoConversion = valor * valorConversion;

                System.out.println("su tasa de conversion de " + moneda_base + " con valor de " + valor + " a " + moneda_destino + " es : (" + resultadoConversion + ")");
                System.out.println("para salir digite 9 o digite nueva moneda ");
                System.out.println("para realizar otra conversion digite 1");
            }



    }









