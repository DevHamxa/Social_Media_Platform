package com.example.socialmediaplatform.restapi;

import com.example.socialmediaplatform.domain.User;
import com.example.socialmediaplatform.model.FollowModel;
import com.example.socialmediaplatform.model.UserModel;
import com.example.socialmediaplatform.service.FollowService;
import com.example.socialmediaplatform.service.UserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/follows")
@RequiredArgsConstructor
public class FollowController {

    @NonNull
    private final FollowService followService;

    // Retrieve a user's followers
    @GetMapping(value = "/followers", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FollowModel>> getFollowers(@RequestParam Long userId) {
        List<FollowModel> followers = followService.getFollowers(userId).stream().map(FollowModel::getUserFollowers).collect(Collectors.toList());
        return ResponseEntity.ok(followers);
    }

    // Retrieve users followed by a user
    @GetMapping(value = "/following", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FollowModel>> getFollowing(@RequestParam Long userId) {
        List<FollowModel> following = followService.getFollowing(userId).stream().map(FollowModel::getFollowingsOfUser).collect(Collectors.toList());
        return ResponseEntity.ok(following);
    }
}

