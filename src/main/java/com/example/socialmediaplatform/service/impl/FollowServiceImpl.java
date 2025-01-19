package com.example.socialmediaplatform.service.impl;

import com.example.socialmediaplatform.domain.Follow;
import com.example.socialmediaplatform.domain.User;
import com.example.socialmediaplatform.repository.FollowRepository;
import com.example.socialmediaplatform.repository.UserRepository;
import com.example.socialmediaplatform.service.FollowService;
import com.example.socialmediaplatform.service.UserService;
import com.example.socialmediaplatform.utils.ResourceNotFoundException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FollowServiceImpl implements FollowService {

    @NonNull
    private final FollowRepository followRepository;

    @Override
    public List<Follow> getFollowers(Long userId) {
        List<Follow> follows = followRepository.findAllByFollowedId(userId);
        if (ObjectUtils.isEmpty(follows)) {
            throw new ResourceNotFoundException();
        }
        return follows;
    }

    @Override
    public List<Follow> getFollowing(Long userId) {
        List<Follow> follows = followRepository.findAllByFollowerId(userId);
        if (ObjectUtils.isEmpty(follows)) {
            throw new ResourceNotFoundException();
        }
        return follows;
    }
}
