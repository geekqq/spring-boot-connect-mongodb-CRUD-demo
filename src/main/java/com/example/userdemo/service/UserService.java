package com.example.userdemo.service;

import com.example.userdemo.model.User;
import com.example.userdemo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public User getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }


    public void updateUser(int id, User user) {
        User user1 = userRepository.findById(id).orElse(null);
        if (user1 == null) {
            userRepository.save(user);
        } else {
            user1.setUserName(user.getUserName());
            user1.setGender(user.getGender());
            user1.setEmail(user.getEmail());
            userRepository.save(user1);
        }

    }
    public void deleteUserById(int id) {
        userRepository.deleteById(id);
    }
}
