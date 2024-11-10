import java.util.Map;

public record Monedas(String baseCode) {

    public Monedas(String monedaBase, String monedaDestino, double valor) {
    }

    public static void add(Monedas registro) {
    }

    public Map<String, Double> getConversion_rates() {
        return Map.of();
    }
}
