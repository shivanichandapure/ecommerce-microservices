package com.shivani.ecommerce.product.ecommerce_product_service.model;

import lombok.Data;
@Data
public class ProductResponseDTO
{
    private Long id;

    private String name;

    private String description;

    private double price;

    private int quantity;

    private String category;
}
