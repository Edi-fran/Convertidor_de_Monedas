import com.google.gson.JsonObject;

public class ConversorDolar extends Conversor {

    public ConversorDolar(double cantidad, JsonObject tasas) {
        super(cantidad, tasas);
    }

    // Implementación del método de conversión
    @Override
    public double convertir(String monedaDestino) {
        if (tasas.has(monedaDestino)) {
            double tasaCambio = tasas.get(monedaDestino).getAsDouble();
            return cantidad * tasaCambio;
        } else {
            System.out.println("Tasa de cambio no disponible para " + monedaDestino);
            return 0.0;
        }
    }

    // Puedes sobrescribir el getter si la moneda de origen cambia (en este caso sigue siendo USD)
    @Override
    public String getMonedaOrigen() {
        return "USD";
    }
}
