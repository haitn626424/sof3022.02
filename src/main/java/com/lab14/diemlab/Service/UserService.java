package com.lab14.diemlab.Service;

import com.lab14.diemlab.Entity.User;
import com.lab14.diemlab.Repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findByUsername(int id) {
        return  userRepository.findById(id).orElseThrow(()-> new RuntimeException("User not found!"));
    }

    public void addUser(User user) {
        userRepository.save(user);
    }
    public void updateUser(User user) {
         userRepository.save(user);
    }
    public void deleteUser(Integer id) {
        if(userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
        }
        else {
            throw new EntityNotFoundException("User not found");
        }
    }
}
