import java.util.Scanner;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ConversorMonedasApp {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        // Obtener las tasas de cambio desde la API
        ClienteAPI clienteAPI = new ClienteAPI();
        String respuestaJson = clienteAPI.obtenerTasasDeCambio();

        // Usando Gson para analizar el JSON y extraer las tasas
        JsonObject tasas = JsonParser.parseString(respuestaJson).getAsJsonObject().getAsJsonObject("conversion_rates");

        boolean salir = false;
        while (!salir) {
            // Mostrar menú interactivo con más monedas
            System.out.println("****************************************");
            System.out.println("Sea bienvenido/a al Conversor de Moneda =]");
            System.out.println("1) Dólar => Peso argentino");
            System.out.println("2) Peso argentino => Dólar");
            System.out.println("3) Dólar => Real brasileño");
            System.out.println("4) Real brasileño => Dólar");
            System.out.println("5) Dólar => Peso colombiano");
            System.out.println("6) Peso colombiano => Dólar");
            System.out.println("7) Dólar => Euro");
            System.out.println("8) Euro => Dólar");
            System.out.println("9) Dólar => Libra esterlina (GBP)");
            System.out.println("10) Libra esterlina (GBP) => Dólar");
            System.out.println("11) Dólar => Yen japonés (JPY)");
            System.out.println("12) Yen japonés (JPY) => Dólar");
            System.out.println("13) Salir");
            System.out.println("****************************************");
            System.out.print("Elija una opción válida: ");
            int opcion = scanner.nextInt();

            // Manejo de la opción seleccionada
            switch (opcion) {
                case 1:
                    realizarConversion(tasas, new ConversorDolar(1.0, tasas), "ARS", scanner);
                    break;
                case 2:
                    realizarConversionInversa(tasas, new ConversorDolar(1.0, tasas), "ARS", scanner); // ARS a USD
                    break;
                case 3:
                    realizarConversion(tasas, new ConversorDolar(1.0, tasas), "BRL", scanner);
                    break;
                case 4:
                    realizarConversionInversa(tasas, new ConversorDolar(1.0, tasas), "BRL", scanner); // BRL a USD
                    break;
                case 5:
                    realizarConversion(tasas, new ConversorDolar(1.0, tasas), "COP", scanner);
                    break;
                case 6:
                    realizarConversionInversa(tasas, new ConversorDolar(1.0, tasas), "COP", scanner); // COP a USD
                    break;
                case 7:
                    realizarConversion(tasas, new ConversorDolar(1.0, tasas), "EUR", scanner); // USD a EUR
                    break;
                case 8:
                    realizarConversionInversa(tasas, new ConversorDolar(1.0, tasas), "EUR", scanner); // EUR a USD
                    break;
                case 9:
                    realizarConversion(tasas, new ConversorDolar(1.0, tasas), "GBP", scanner); // USD a GBP
                    break;
                case 10:
                    realizarConversionInversa(tasas, new ConversorDolar(1.0, tasas), "GBP", scanner); // GBP a USD
                    break;
                case 11:
                    realizarConversion(tasas, new ConversorDolar(1.0, tasas), "JPY", scanner); // USD a JPY
                    break;
                case 12:
                    realizarConversionInversa(tasas, new ConversorDolar(1.0, tasas), "JPY", scanner); // JPY a USD
                    break;
                case 13:
                    salir = true;
                    System.out.println("Gracias por usar el conversor de moneda. ¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción no válida, intente de nuevo.");
            }
        }
    }

    // Método que realiza la conversión entre dos monedas
    public static void realizarConversion(JsonObject tasas, Conversor conversor, String monedaDestino, Scanner scanner) {
        System.out.print("Ingrese la cantidad en " + conversor.getMonedaOrigen() + ": ");
        double cantidad = scanner.nextDouble();
        conversor.setCantidad(cantidad);

        // Conversión normal de USD a otra moneda
        double resultado = conversor.convertir(monedaDestino);
        System.out.println(cantidad + " " + conversor.getMonedaOrigen() + " son " + resultado + " " + monedaDestino);
    }

    // Método especial para convertir de otra moneda a USD
    public static void realizarConversionInversa(JsonObject tasas, Conversor conversor, String monedaOrigen, Scanner scanner) {
        System.out.print("Ingrese la cantidad en " + monedaOrigen + ": ");
        double cantidad = scanner.nextDouble();
        conversor.setCantidad(cantidad);

        // Invertir la tasa de cambio si es hacia USD
        double tasaOrigen = tasas.get(monedaOrigen).getAsDouble();
        double resultado = cantidad / tasaOrigen; // Dividimos la cantidad por la tasa
        System.out.println(cantidad + " " + monedaOrigen + " son " + resultado + " USD");
    }
}





