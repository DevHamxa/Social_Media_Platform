package com.example.socialmediaplatform.service;

import com.example.socialmediaplatform.domain.User;
import com.example.socialmediaplatform.model.UserModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    User getUser(Long userId);

    User registerUser(String email, String password);

    //List getFollowers(Long id);
}
