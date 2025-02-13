package com.JjTFProducts.Producto_TareaFinal.Service;

import com.JjTFProducts.Producto_TareaFinal.Model.Product;
import com.JjTFProducts.Producto_TareaFinal.Repository.ProductRepository;
import com.JjTFProducts.Producto_TareaFinal.Utiles.ProductNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio que gestiona la lógica de negocio relacionada con los productos.
 * Se encarga de interactuar con el repositorio para realizar operaciones CRUD.
 */
@Service
public class ProductService {

    // Inyección de dependencia de ProductRepository para acceder a la base de datos.
    @Autowired
    private ProductRepository productRepository;

    /**
     * Guarda un nuevo producto en la base de datos.
     *
     * @param product El producto a guardar.
     * @return El producto guardado con su ID generado.
     */
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    /**
     * Obtiene un producto por su ID.
     *
     * @param productID ID del producto a buscar.
     * @return El producto encontrado.
     * @throws ProductNotFound Si el producto no existe en la base de datos.
     */
    public Product getProduct(long productID) {
        return productRepository.findById(productID)
                .orElseThrow(() -> new ProductNotFound("Producto no encontrado con ID " + productID));
    }

    /**
     * Obtiene la lista de todos los productos almacenados en la base de datos.
     *
     * @return Lista de productos disponibles.
     */
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    /**
     * Actualiza la información de un producto existente.
     *
     * @param productID ID del producto a actualizar.
     * @param product   Datos actualizados del producto.
     * @return El producto actualizado.
     * @throws ProductNotFound Si el producto no existe en la base de datos.
     */
    public Product updateProduct(long productID, Product product) {
        Product existingProduct = productRepository.findById(productID)
                .orElseThrow(() -> new ProductNotFound("Producto no encontrado para actualizar con ID " + productID));

        // Se actualizan los campos del producto existente con los nuevos valores
        existingProduct.setProductName(product.getProductName());
        existingProduct.setPrice(product.getPrice());

        // Se guarda el producto actualizado en la base de datos
        productRepository.save(existingProduct);
        return existingProduct;
    }

    /**
     * Elimina un producto por su ID.
     *
     * @param productID ID del producto a eliminar.
     * @return El producto eliminado.
     * @throws ProductNotFound Si el producto no existe en la base de datos.
     */
    public Product deleteProduct(long productID) {
        Product existingProduct = productRepository.findById(productID)
                .orElseThrow(() -> new ProductNotFound("Producto no encontrado para eliminar con ID " + productID));

        productRepository.deleteById(productID);
        return existingProduct;
    }

    /**
     * Obtiene productos por su nombre.
     *
     * @param productName Nombre del producto a buscar.
     * @return Lista de productos que coinciden con el nombre proporcionado.
     * @throws ProductNotFound Si no se encuentra ningún producto con el nombre especificado.
     */
    public List<Product> getProductsByName(String productName) {
        if (productName == null || productName.trim().isEmpty()) {
            throw new ProductNotFound("El nombre del producto proporcionado está vacío o es nulo.");
        }

        List<Product> productsByName = productRepository.getProductsByName(productName);
        if (productsByName.isEmpty()) {
            throw new ProductNotFound("No se encontraron productos con el nombre: " + productName);
        }

        return productsByName;
    }
}
