package com.example.socialmediaplatform.service;

import com.example.socialmediaplatform.domain.User;
import java.util.List;

public interface UserService {
    User getUser(Long userId);

    //List getFollowers(Long id);
}
