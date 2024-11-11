
import java.util.Scanner;

public class Menu {

    Scanner scanner = new Scanner(System.in);
    BusquedaConversor buscarMoneda = new BusquedaConversor();

    public void mostrarMenu(){

        System.out.println("Introduce la moneda de origen");
    String moneda_base = scanner.nextLine(). trim().toUpperCase();

        System.out.println("Introduce la moneda de destino");
    String moneda_destino = scanner.nextLine().trim().toUpperCase();

        System.out.println("Introduce el monto a convertir: ");
    double valor = scanner.nextDouble();
        scanner.nextLine();

    double valorConversion = buscarMoneda.convertirMoneda(moneda_base,moneda_destino);
    double resultadoConversion = valor * valorConversion;

        System.out.println(resultadoConversion);





}

}