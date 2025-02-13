package com.JjTFProducts.Producto_TareaFinal.Utiles;

/**
 * Excepción personalizada para manejar casos en los que un producto no se encuentra en la base de datos.
 * Esta excepción extiende RuntimeException, permitiendo que sea capturada por el `GlobalExceptionHandler`
 * para devolver un código HTTP adecuado y un mensaje descriptivo al usuario.
 */
public class ProductNotFound extends RuntimeException {

    /**
     * Constructor que recibe un mensaje de error y lo pasa a la superclase RuntimeException
     * @param message Mensaje descriptivo del error indicando que el producto no fue encontrado.
     */
    public ProductNotFound(String message) {
        super(message);
    }
}
