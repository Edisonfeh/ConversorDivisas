import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BusquedaConversor {

    public Double convertirMoneda( String monedaBase, String monedaDestino) {

        String apikey = System.getenv("EXHANGE_API_KEY");
        if (apikey == null || apikey.isEmpty() ){
            throw new RuntimeException("Exhange API Key no esta configurada");

        }
        // construccion de lka URI usando clave APIKEY y la moneda base
            URI direccion = URI.create("https://v6.exchangerate-api.com/v6/e277ca8a536139e4b651cf92/latest/" + monedaBase);
        // creación de htttp client, necesario para hacer la solicitud
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(direccion)
                    .build();
            HttpResponse<String> response = null;
            try {
                response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }

            return new Gson().fromJson(response.body(), Moneda.class);
        }

    }

}
