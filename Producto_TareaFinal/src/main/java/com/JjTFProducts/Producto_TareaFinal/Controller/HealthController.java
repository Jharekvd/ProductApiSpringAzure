package com.JjTFProducts.Producto_TareaFinal.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador para verificar el estado de salud del servicio.
 * Este controlador expone un endpoint `/health` que devuelve un HTTP 200 (OK)
 * para indicar que el servicio está operativo.
 */
@RestController
public class HealthController {

    /**
     * Endpoint para verificar el estado de salud del servicio.
     * Este método retorna un HTTP 200 (OK) con un mensaje simple
     * para indicar que el servicio está activo.
     *
     * @return ResponseEntity con el código 200 y el mensaje "Service is Up".
     */
    @GetMapping("/health")
    public ResponseEntity<String> health() {
        // Devuelve un estado HTTP 200 con un mensaje en el cuerpo de la respuesta.
        return ResponseEntity.ok("Service encendido");
    }
}

