package com.JjTFProducts.Producto_TareaFinal.Repository;

import com.JjTFProducts.Producto_TareaFinal.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// Esta interfaz hereda las funcionalidades de JpaRepository, como:
// - findAll(): obtener todos los registros de la entidad Product.
// - findById(Long id): buscar un Product por su ID.
// - save(Product product): guardar o actualizar un Product.
// - delete(Product product): eliminar un Product.
//
// JpaRepository también proporciona soporte para paginación y ordenación.
public interface ProductRepository extends JpaRepository<Product,Long> {
    @Query(value = "SELECT * FROM product_inventory_aws where product_name = ?1",nativeQuery = true)
    List<Product>getProductsByName(String productName);
}
