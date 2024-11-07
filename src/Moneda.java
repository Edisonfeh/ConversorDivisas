import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.Map;

public record Moneda( String baseCode,
                        Map <String, Double> conversionRates )  {
                        }
