package com.JjTFProducts.Producto_TareaFinal.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "product_inventory_aws")
@Data
//Lombok para getters y setters
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idProduct;
    @Column(name = "product_name", nullable = false)
    @NotNull(message = "El nombre del producto no puede ser nulo.")
    @Size(min = 3, max = 50, message = "El nombre del producto debe tener entre 3 y 50 caracteres.")
    private String productName;
    @Column(name = "product_price", nullable = false)
    @NotNull(message = "El precio no debe ser nulo.")
    @Positive(message = "El precio debe ser un número positivo.")
    private Double price;
    //updatable = false no permite que el valor sea cambiado
    //La fecha en la que se crea un producto
    @Column(name = "create_date", updatable = false)
    private LocalDateTime create_Date;

    @PrePersist
    protected void setCreationDate() {
        this.create_Date = LocalDateTime.now();
    }
}
