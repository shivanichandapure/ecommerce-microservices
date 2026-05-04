package com.shivani.ecommerce.product.ecommerce_product_service.client;

import com.shivani.ecommerce.product.ecommerce_product_service.model.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name= "USER-SERVICE")
public interface UserClient
{
    @GetMapping("/users")
    List<UserDTO> getAllUsers();
}
