package com.example.socialmediaplatform.service.impl;

import com.example.socialmediaplatform.domain.User;
import com.example.socialmediaplatform.repository.UserRepository;
import com.example.socialmediaplatform.service.UserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @NonNull
    private final UserRepository userRepository;

    public User getUser(Long userId) {
        return userRepository.findByWebId(userId);
    }
}
