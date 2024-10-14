import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ClienteAPI {
    // Actualiza la URL con tu clave de API
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/22b84c62a52a85ece5a31aa7/latest/USD";

    public String obtenerTasasDeCambio() throws Exception {
        URL url = new URL(API_URL);
        HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
        conexion.setRequestMethod("GET");

        BufferedReader lector = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
        String linea;
        StringBuilder respuesta = new StringBuilder();

        while ((linea = lector.readLine()) != null) {
            respuesta.append(linea);
        }
        lector.close();

        return respuesta.toString();  // Retorna el JSON con las tasas de cambio
    }
}



