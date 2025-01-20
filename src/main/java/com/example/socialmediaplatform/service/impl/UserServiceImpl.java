package com.example.socialmediaplatform.service.impl;

import com.example.socialmediaplatform.domain.User;
import com.example.socialmediaplatform.model.UserModel;
import com.example.socialmediaplatform.repository.UserRepository;
import com.example.socialmediaplatform.service.UserService;
import com.example.socialmediaplatform.utils.ResourceAlreadyExistsException;
import com.example.socialmediaplatform.utils.ResourceNotFoundException;
import jakarta.persistence.NoResultException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @NonNull
    private final UserRepository userRepository;

    @NonNull
    private final PasswordEncoder passwordEncoder;

    public User getUser(Long userId) {
        User user = userRepository.findByWebId(userId);
        if (ObjectUtils.isEmpty(user)) {
            throw new ResourceNotFoundException();
        }
        return user;
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User registerUser(String email, String password) {
        // Check if the username already exists
        User oldUser = userRepository.findByEmail(email);
        if (!ObjectUtils.isEmpty(oldUser)) {
            throw new ResourceAlreadyExistsException();
        }
        // Encode the password
        String encodedPassword = passwordEncoder.encode(password);

        // Create a new user and save it to the database
        User user = new UserModel(email, encodedPassword).assemble();
        user = userRepository.save(user);

        return user;
    }
}
