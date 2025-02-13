package com.JjTFProducts.Producto_TareaFinal.Utiles;

import com.JjTFProducts.Producto_TareaFinal.Model.ProductErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * @ControllerAdvice: Indica que esta clase manejará excepciones globalmente en toda la aplicación.
 * En lugar de manejar cada excepción en los controladores, centralizamos su manejo aquí.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Maneja la excepción ProductNotFound.
     * Se lanza cuando un producto no se encuentra en la base de datos.
     * Devuelve un código de estado 404 (NOT FOUND) junto con el mensaje de error.
     *
     * @param ex Excepción personalizada ProductNotFound.
     * @return ResponseEntity con el mensaje de error y estado 404.
     */
    @ExceptionHandler(ProductNotFound.class)
    public ResponseEntity<ProductErrorResponse> handleProductNotFoundException(ProductNotFound ex, HttpServletRequest request) {
        // Crear una instancia de ProductErrorResponse
        ProductErrorResponse errorResponse = new ProductErrorResponse();
        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponse.setError(HttpStatus.NOT_FOUND.getReasonPhrase());
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setTimestamp(LocalDateTime.now().toString());
        errorResponse.setPath(request.getRequestURI());

        // Devolver la respuesta con el estado 404 y el cuerpo del error
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    /**
     * Maneja errores de validación de entrada de datos.
     * Captura excepciones cuando un objeto enviado en la petición no cumple con las validaciones definidas en el modelo.
     * Devuelve un código de estado 400 (BAD REQUEST) con un mapa de errores donde:
     * - La clave es el nombre del campo con error.
     * - El valor es el mensaje de validación correspondiente.
     *
     * @param ex Excepción MethodArgumentNotValidException generada por validaciones de @Valid.
     * @return ResponseEntity con un mapa de errores y estado 400.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        // Recorre los errores de validación y construye un mapa con los detalles
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    /**
     * Captura cualquier otra excepción no manejada en la aplicación.
     * Esto ayuda a evitar que errores inesperados expongan información sensible al usuario.
     * Devuelve un código de estado 500 (INTERNAL SERVER ERROR) con un mensaje genérico.
     *
     * @param ex Cualquier excepción no manejada.
     * @return ResponseEntity con un mensaje de error genérico y estado 500.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception ex) {
        return new ResponseEntity<>("Ocurrió un error inesperado.", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Maneja la excepción InvalidInputException.
     * Se lanza cuando un usuario ingresa un valor inválido (por ejemplo, un campo vacío o incorrecto).
     * Devuelve un código de estado 400 (BAD REQUEST) con el mensaje de error correspondiente.
     *
     * @param ex Excepción personalizada InvalidInputException.
     * @return ResponseEntity con el mensaje de error y estado 400.
     */
    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity<ProductErrorResponse> handleInvalidInputException(InvalidInputException ex, HttpServletRequest request) {
        ProductErrorResponse errorResponse = new ProductErrorResponse();
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setError(HttpStatus.BAD_REQUEST.getReasonPhrase());
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setTimestamp(LocalDateTime.now().toString());
        errorResponse.setPath(request.getRequestURI());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
