import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class BusquedaConversor {

    public Double convertirMoneda(String monedaBase, String monedaDestino) {

        String apikey = System.getenv("API_KEY");
        if (apikey == null || apikey.isEmpty()) {
            throw new RuntimeException("La clave API Key no esta configurada");

        }

        //1. construccion de la URI usando clave APIKEY y la moneda base
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/"+ apikey +"/latest/" + monedaBase);

        // 2. creación de htttp client, necesario para hacer la solicitud

        HttpClient client = HttpClient.newHttpClient();
        //3. Contruye la socilicitud HTP (Usando en el paso 10)
        //La solicitud utiliza un metodo GET, que es el emtodo predeterminado en Httprequest
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();


        try {
            // 4. Envia la solicitud y almacena la respuesta
            // El metodo "send" realiza la solicitud y espera una respuesta que luego se almacena en "response"
            //"BodyHandlers.ofString()" indica que queremos la respuesta en formato de texto

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            //5. Convierte la respuesta JSON en un objeto de la clase Moneda usando Gson
            //Esto deserializa el JSON y nos permite acceder a los datos de manera mas estructurada

            Monedas moneda = new Gson().fromJson(response.body(), Monedas.class);

            // 6. Obtiene el mapa de tasas de conversion de la respuesta deserializada
            // El metodo "conversion_rate()" devuelve un mapa con las tasas de conversion de diferente monedas

            Map<String, Double> conversionRates = moneda.conversion_rates();

            //7. Busca la tasa de conversion especifica para la moneda de destino
            Double tasaConversion = conversionRates.get(monedaDestino);

            //8. Verifica si la tasa de conversion para la moneda de destino fue encontrada

                if (tasaConversion != null) {
                    // Si existe una tasa para la moneda destino, la devulve como resultado
                    return tasaConversion;
                } else {
                    //Si la tasa no se encuentra, lanza un error indicando que no existe conversion
                    throw new RuntimeException("Tasa de conversion no encontrada para la moneda destino");
                }
            } catch (Exception e) {
                //9. Si ocurre algun error (como problemas de red, error en la API, etc), lanza una excepcion
                throw new RuntimeException("Error en la conversion de la moneda destino ");
            }

        }
    }








