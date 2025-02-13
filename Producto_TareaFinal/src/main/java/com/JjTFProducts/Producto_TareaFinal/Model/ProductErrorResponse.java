package com.JjTFProducts.Producto_TareaFinal.Model;

import lombok.Data;

@Data
public class ProductErrorResponse {

    private int status;
    private String error;
    private String message;
    private String timestamp;
    private String path;

}
