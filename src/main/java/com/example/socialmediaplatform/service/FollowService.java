package com.example.socialmediaplatform.service;

import com.example.socialmediaplatform.domain.Follow;
import com.example.socialmediaplatform.domain.User;

import java.util.Arrays;
import java.util.List;

public interface FollowService {
    List<Follow> getFollowers(Long userId);

    List<Follow> getFollowing(Long userId);
}
