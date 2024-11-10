import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private List<BusquedaConversor> busquedaConversion = new ArrayList<>();
      // Creacion del metodo que realiza la conversion de moneda y devuelve el resultado como una cadena de texto

    public String resultadoConversion(String monedaBase, String monedaDestino, double valor){
        //1. Crea una instancia de la clase de la clase BusquedaConversor
        BusquedaConversor busquedaConversor = new BusquedaConversor();

        // 2.llamada del metodo convertitMoneda () para obtener la tasa de conversion entre la moneda base y la moneda destino
        double tasaConversion = busquedaConversor.convertirMoneda(monedaBase, monedaDestino);

        //3. calcula el valor convertido multiplicando la tasa de conversion por el valor ingresado
        double resultado = valor * tasaConversion;

        //4. Formatea el resultado en una cadena con un mensaje descriptivo
        //Muestra las monedas involucradas y el resultado de la conversion, con dos decimales
        String respuesta = String.format("%.2f",monedaBase,monedaDestino, resultado);

        //5. Registra la conversion realizada para mantener un historial
        //crea un nuevo objeto de Monedas con los detalles de la conversion
        Monedas registro = new Monedas(monedaBase, monedaDestino, valor);

        //6. Agrega el  uevo registro a la lista de registrosConversion

        Monedas.add(registro);

        //Devuelve la respuesta formateada con el resultado de la conversion
        return respuesta;

    }

}
