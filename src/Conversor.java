import com.google.gson.JsonObject;

public abstract class Conversor {
    protected double cantidad;
    protected JsonObject tasas;

    public Conversor(double cantidad, JsonObject tasas) {
        this.cantidad = cantidad;
        this.tasas = tasas;
    }

    // Método abstracto para convertir a una moneda específica
    public abstract double convertir(String moneda);

    // Getter para la cantidad
    public double getCantidad() {
        return cantidad;
    }

    // Setter para la cantidad
    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    // Getter para obtener la moneda de origen (USD en este caso por defecto)
    public String getMonedaOrigen() {
        return "USD";
    }
}


