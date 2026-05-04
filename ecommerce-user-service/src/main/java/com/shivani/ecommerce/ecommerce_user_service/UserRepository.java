package com.shivani.ecommerce.ecommerce_user_service;

import com.shivani.ecommerce.ecommerce_user_service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
