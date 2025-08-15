package com.example.springboot_mysql_demo.Services;

import com.example.springboot_mysql_demo.models.User;
import com.example.springboot_mysql_demo.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepo;

    public UserService(UserRepository userRepository)
    {
        this.userRepo = userRepository;
    }

    // Create
    public User createUser(User user)
    {
        //Basic Validation
        if(!StringUtils.hasText(user.getName()) || !StringUtils.hasText(user.getEmail()))
        {
            throw new IllegalArgumentException("Name & Email are Required");
        }
        if(userRepo.existsByEmail(user.getEmail()))
        {
            throw new IllegalArgumentException("Email already in use: " + user.getEmail());
        }
        return userRepo.save(user);
    }

    // READ
    public User getUserById(Long id)
    {
        return userRepo.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("%d not found", id)));
    }

    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    //UPDATE -> patch (partial) - put (complete i.e. erase if exists or create if doest not exist)
    public User updateUser(Long id, User newUser)
    {
        User existing = userRepo.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("%d not found", id)));

        if(StringUtils.hasText(newUser.getName()))
        {
            existing.setName(newUser.getName());
        }
        if(StringUtils.hasText(newUser.getEmail()))
        {
            if(existing.getEmail().equals(newUser.getEmail()) && userRepo.existsByEmail(newUser.getEmail()))
            {
                throw new IllegalArgumentException("Email already in use: " + newUser.getEmail());
            }
            existing.setEmail(newUser.getEmail());
        }

        existing.setName(newUser.getName());
        existing.setEmail(newUser.getEmail());
        return userRepo.save(existing);
    }

    //DELETE
    public void deleteUser(Long id)
    {
        userRepo.deleteById(id);
    }
}
