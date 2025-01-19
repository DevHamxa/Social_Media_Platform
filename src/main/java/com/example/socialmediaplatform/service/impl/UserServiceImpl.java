package com.example.socialmediaplatform.service.impl;

import com.example.socialmediaplatform.domain.User;
import com.example.socialmediaplatform.repository.UserRepository;
import com.example.socialmediaplatform.service.UserService;
import com.example.socialmediaplatform.utils.ResourceNotFoundException;
import jakarta.persistence.NoResultException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @NonNull
    private final UserRepository userRepository;

    public User getUser(Long userId) {
        User user = userRepository.findByWebId(userId);
        if (ObjectUtils.isEmpty(user)) {
            throw new ResourceNotFoundException();
        }
        return user;
    }
}
