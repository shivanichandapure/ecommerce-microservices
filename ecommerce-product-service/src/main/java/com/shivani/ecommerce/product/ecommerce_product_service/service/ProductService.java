package com.shivani.ecommerce.product.ecommerce_product_service.service;

import com.shivani.ecommerce.product.ecommerce_product_service.entity.Product;
import com.shivani.ecommerce.product.ecommerce_product_service.model.ProductResponseDTO;
import com.shivani.ecommerce.product.ecommerce_product_service.model.UserDTO;

import java.util.List;

public interface ProductService {
    void addProduct(Product product);

    ProductResponseDTO getproduct(long id);   // ✅ changed

    List<ProductResponseDTO> getProducts();

    Product updateProduct(long id, Product product);

    void deleteProduct(long id);

    List<UserDTO> getUsersFromUserService();
}
