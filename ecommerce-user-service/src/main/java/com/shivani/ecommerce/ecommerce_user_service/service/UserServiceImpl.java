package com.shivani.ecommerce.ecommerce_user_service.service;
import com.shivani.ecommerce.ecommerce_user_service.UserRepository;
import com.shivani.ecommerce.ecommerce_user_service.entity.User;
import com.shivani.ecommerce.ecommerce_user_service.model.UserResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserRepository userRepository;
    @Override
    public long saveuser(User user)
    {
        if(user.getEmail()==null || user.getEmail().isEmpty())
        {
            throw new RuntimeException("Email is required");
        }
        userRepository.save(user);
        return user.getId();
    }
    @Override
    public UserResponseDTO getuser(long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id"));

        UserResponseDTO dto = new UserResponseDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        return dto;
   }
    @Override
    public List<UserResponseDTO> getalluser() {

        List<User> users = userRepository.findAll();
        List<UserResponseDTO> list = new ArrayList<>();

        for (User user : users) {
            UserResponseDTO dto = new UserResponseDTO();
            dto.setId(user.getId());
            dto.setName(user.getName());
            dto.setEmail(user.getEmail());
            list.add(dto);
        }
        return list;
    }
    @Override
    public void updateUser(long id, UserResponseDTO dto) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        userRepository.save(user);
    }
    @Override
    public void deleteUser(long id)
    {
        userRepository.deleteById(id);
    }
}
