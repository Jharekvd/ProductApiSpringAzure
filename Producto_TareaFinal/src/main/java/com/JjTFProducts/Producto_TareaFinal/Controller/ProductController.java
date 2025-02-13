package com.JjTFProducts.Producto_TareaFinal.Controller;

import com.JjTFProducts.Producto_TareaFinal.Model.Product;
import com.JjTFProducts.Producto_TareaFinal.Service.ProductService;
import com.JjTFProducts.Producto_TareaFinal.Utiles.InvalidInputException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * Inserta un producto en la base de datos.
     * @param product Producto a guardar, validado con @Valid.
     * @return ResponseEntity con el producto guardado y código de estado 201 (CREATED).
     */
    @PostMapping("/product")
    public ResponseEntity<Product> saveProduct(@Valid @RequestBody Product product) {
        Product saveProduct = productService.saveProduct(product);
        return new ResponseEntity<>(saveProduct, HttpStatus.CREATED);
    }

    /**
     * Obtiene la lista de todos los productos disponibles en la base de datos.
     * @return Lista de productos.
     */
    @GetMapping("/products")
    public List<Product> getProduct(){
        return productService.getProducts();
    }

    /**
     * Obtiene un producto específico por su ID.
     * @param productID ID del producto a buscar.
     * @return ResponseEntity con el producto encontrado y código de estado 200 (OK).
     */
    @GetMapping("/products/{productID}")
    public ResponseEntity<Product> getProduct(@PathVariable long productID) {
        Product product = productService.getProduct(productID);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    /**
     * Elimina un producto de la base de datos por su ID.
     * @param productID ID del producto a eliminar.
     * @return ResponseEntity con el producto eliminado y código de estado 200 (OK).
     */
    @DeleteMapping("/products/{productID}")
    public ResponseEntity<Product> deleteProduct(@PathVariable long productID){
        Product deleteProduct = productService.deleteProduct(productID);
        return new ResponseEntity<>(deleteProduct, HttpStatus.OK);
    }

    /**
     * Actualiza la información de un producto específico.
     * @param productID ID del producto a actualizar.
     * @param product Datos actualizados del producto.
     * @return ResponseEntity con el producto actualizado y código de estado 200 (OK).
     */
    @PatchMapping("/products/{productID}")
    public ResponseEntity<Product> updateProduct(@PathVariable long productID, @Valid @RequestBody Product product){
        Product updateProduct = productService.updateProduct(productID, product);
        return new ResponseEntity<>(updateProduct, HttpStatus.OK);
    }

    /**
     * Obtiene una lista de productos que coinciden con un nombre específico.
     * @param productName Nombre del producto a buscar.
     * @return Lista de productos que coinciden con el nombre.
     * @throws InvalidInputException si el nombre proporcionado está vacío o es nulo.
     */
    @GetMapping("/products/search")
    public List<Product> getProductsByName(@RequestParam("productName") String productName){
        if (productName == null || productName.trim().isEmpty()) {
            throw new InvalidInputException("El nombre del producto proporcionado está vacío o es nulo.");
        }
        return productService.getProductsByName(productName);
    }
}
