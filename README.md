
# Explicación de las Clases y Variables del Proyecto Convertidor de Monedas ALURA_LATAM

Este documento detalla cómo funcionan las clases y las variables en el proyecto de **Convertidor de Monedas** en Java
   -se utilizo   el lenguje  orientado a objetos java (jdk 17)
   -Se utilizo el editor de codigo Itellij Idea(comunity)
   -Implemento el consumo de apis externas 
   - se uso  la clase Gson de google  
   - Postman  para verificcar si la api  estaba dando la informacio  correcta  sobre los valores  de la moneda 
   
# Para consumir la informacion se  uso las siguientes clases 
   import java.io.BufferedReader;
   import java.io.InputStreamReader;
   import java.net.HttpURLConnection;
   import java.net.URL;



## 1. Clase `ConversorMonedasApp`

### Variables principales:
1. **scanner** (`Scanner scanner = new Scanner(System.in);`)
   - Esta variable se utiliza para **leer lo que el usuario escribe en la consola**. Se usa para obtener la opción del menú o la cantidad a convertir.

2. **opcion** (`int opcion;`)
   - Guarda la **opción que el usuario elige en el menú**. Permite identificar qué tipo de conversión el usuario desea realizar.

3. **cantidad** (`double cantidad;`)
   - Almacena la **cantidad de dinero que el usuario desea convertir**.

4. **continuar** (`boolean continuar = true;`)
   - Controla si la aplicación sigue ejecutándose o se detiene. Mientras sea `true`, el menú seguirá apareciendo.

## 2. Clase `Conversor`

### Variables principales:
1. **tasaCambio** (`double tasaCambio;`)
   - Guarda la **tasa de cambio** que se utiliza para la conversión entre las monedas. 

2. **monedaOrigen** (`String monedaOrigen;`)
   - Guarda el **código o nombre de la moneda** desde la cual se realiza la conversión, como "USD".

3. **monedaDestino** (`String monedaDestino;`)
   - Almacena el **código o nombre de la moneda** hacia la cual se convierte, como "ARS" para pesos argentinos.

4. **cantidadConvertida** (`double cantidadConvertida;`)
   - Guarda el **resultado de la conversión** después de aplicar la tasa de cambio.

## 3. Clase `ConversorDolar`

### Variables principales:
1. **apiCliente** (`ClienteAPI apiCliente = new ClienteAPI();`)
   - Se encarga de **hacer las llamadas a la API** para obtener las tasas de cambio actuales.

2. **resultado** (`double resultado;`)
   - Almacena el **valor final de la conversión** una vez aplicada la tasa de cambio.

## 4. Clase `ClienteAPI`

### Variables principales:
1. **apiUrl** (`String apiUrl = "https://api.exchangeratesapi.io/latest";`)
   - Almacena la **URL** de la API que se utiliza para obtener las tasas de cambio.

2. **respuestaJSON** (`String respuestaJSON;`)
   - Guarda la **respuesta en formato JSON** obtenida de la API después de realizar la solicitud.

3. **gson** (`Gson gson = new Gson();`)
   - Este objeto permite **convertir el JSON en objetos Java**, facilitando la extracción de la tasa de cambio.

4. **tasaCambioActual** (`double tasaCambioActual;`)
   - Almacena la **tasa de cambio específica** que será usada para realizar la conversión entre monedas.

---

Cada variable y clase juega un rol clave en el funcionamiento general de la aplicación, asegurando que la conversión de monedas sea precisa y que la experiencia del usuario sea clara y eficiente.
# Anexos 

para entender la funcionalidad del codigo   les dejo el link de un video  demostrativo  y imagenes cargadas  a google drive :
video :  https://drive.google.com/file/d/1hDY37TFZmlpmtt0KmtHkzBwTL3xWwnPB/view?usp=sharing
imagen de postman:https://drive.google.com/file/d/1NdIrz9Ws9CW3a5O5RpUhqLDcvSj0guc7/view?usp=drive_link
Salida por consola:https://drive.google.com/file/d/11Ux8TMzHAtwn_88fWR5YbKAZbyGPnbcq/view?usp=drive_link
Subida a Github:   https://drive.google.com/file/d/1D8rJG1lXg-Z6hShkhvEQeSavsW6HNUl0/view?usp=drive_link
Codigo : https://github.com/Edi-fran/Convertidor_de_Monedas.git
