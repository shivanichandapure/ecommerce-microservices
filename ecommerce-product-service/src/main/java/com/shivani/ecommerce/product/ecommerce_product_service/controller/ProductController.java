package com.shivani.ecommerce.product.ecommerce_product_service.controller;

import com.shivani.ecommerce.product.ecommerce_product_service.entity.Product;
import com.shivani.ecommerce.product.ecommerce_product_service.model.ProductResponseDTO;
import com.shivani.ecommerce.product.ecommerce_product_service.model.UserDTO;
import com.shivani.ecommerce.product.ecommerce_product_service.service.ProductService;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController
{
    @Autowired
    private ProductService productService;
    @PostMapping("/addproduct")
    public ResponseEntity<String> addProduct(@RequestBody Product product)
    {
        productService.addProduct(product);
        return ResponseEntity.ok("Product added successfully");
    }
    @GetMapping("/getproduct/{id}")
    public ResponseEntity<ProductResponseDTO> getProduct(@PathVariable long id) {
        ProductResponseDTO product = productService.getproduct(id);
        return ResponseEntity.ok(product);
    }
    @GetMapping("/getproducts")
    public ResponseEntity<List<ProductResponseDTO>> getAllProducts() {
        List<ProductResponseDTO> products = productService.getProducts();
        return ResponseEntity.ok(products);
    }
    @PutMapping("/updateproduct/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable long id,
                                                @RequestBody Product product) {
        productService.updateProduct(id, product);
        return ResponseEntity.ok("Product updated successfully");
    }
    @DeleteMapping("/deleteproduct/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok("Product deleted successfully");
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getUsers() {
        return ResponseEntity.ok(productService.getUsersFromUserService());
    }
}
