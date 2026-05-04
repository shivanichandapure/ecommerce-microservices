package com.shivani.ecommerce.ecommerce_user_service.service;

import com.shivani.ecommerce.ecommerce_user_service.entity.User;
import com.shivani.ecommerce.ecommerce_user_service.model.UserResponseDTO;

import java.util.List;

public interface UserService {

    long saveuser(User user);

    UserResponseDTO getuser(long id);

    List<UserResponseDTO> getalluser();


    void updateUser(long id, UserResponseDTO dto);

    void deleteUser(long id);
}
