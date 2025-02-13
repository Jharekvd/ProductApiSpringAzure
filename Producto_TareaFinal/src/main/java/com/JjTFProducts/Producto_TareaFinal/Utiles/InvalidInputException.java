package com.JjTFProducts.Producto_TareaFinal.Utiles;

/**
 * Excepción personalizada para manejar entradas inválidas.
 * Se usa cuando un usuario envía datos incorrectos o vacíos en una solicitud.
 * Esta excepción extiende RuntimeException, lo que permite que Spring la maneje automáticamente
 * en el `GlobalExceptionHandler`, devolviendo una respuesta con un código HTTP adecuado.
 */
public class InvalidInputException extends RuntimeException {

    /**
     * Constructor que recibe un mensaje de error y lo pasa a la superclase RuntimeException.
     * @param message Mensaje descriptivo del error que indica por qué la entrada es inválida.
     */
    public InvalidInputException(String message) {
        super(message);
    }
}
