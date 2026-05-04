package com.shivani.ecommerce.product.ecommerce_product_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class EcommerceProductServiceApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(EcommerceProductServiceApplication.class, args);
	}
}
