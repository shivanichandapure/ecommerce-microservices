package com.shivani.ecommerce.product.ecommerce_product_service.service;

import com.shivani.ecommerce.product.ecommerce_product_service.client.UserClient;
import com.shivani.ecommerce.product.ecommerce_product_service.entity.Product;
import com.shivani.ecommerce.product.ecommerce_product_service.model.ProductResponseDTO;
import com.shivani.ecommerce.product.ecommerce_product_service.model.UserDTO;
import com.shivani.ecommerce.product.ecommerce_product_service.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService
{
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserClient userClient;
    @Override
    public void addProduct(Product product)
    {
        productRepository.save(product);
    }
    @Override
    public ProductResponseDTO getproduct(long id) {

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id"));

        ProductResponseDTO dto = new ProductResponseDTO();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());
        dto.setQuantity(product.getQuantity());
        dto.setCategory(product.getCategory());

        return dto;
    }
    @Override
    public List<ProductResponseDTO> getProducts() {

        List<Product> products = productRepository.findAll();

        List<ProductResponseDTO> list = new java.util.ArrayList<>();

        for (Product product : products) {
            ProductResponseDTO dto = new ProductResponseDTO();
            dto.setId(product.getId());
            dto.setName(product.getName());
            dto.setDescription(product.getDescription());
            dto.setPrice(product.getPrice());
            dto.setQuantity(product.getQuantity());
            dto.setCategory(product.getCategory());
            list.add(dto);
        }

        return list;
    }
    @Override
    public Product updateProduct(long id, Product product)
    {
        Product updatedProduct = productRepository.findById(id).orElseThrow(() ->new RuntimeException("Product not found"));
        updatedProduct.setName(product.getName());
        updatedProduct.setDescription(product.getDescription());
        updatedProduct.setPrice(product.getPrice());
        updatedProduct.setQuantity(product.getQuantity());
        updatedProduct.setCategory(product.getCategory());

        productRepository.save(updatedProduct);

        return updatedProduct;
    }

    @Override
    public void deleteProduct(long id)
    {
         productRepository.deleteById(id);

    }
    public List<UserDTO> getUsersFromUserService() {
        return userClient.getAllUsers();
    }
}
