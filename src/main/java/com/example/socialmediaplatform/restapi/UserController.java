package com.example.socialmediaplatform.restapi;

import com.example.socialmediaplatform.domain.User;
import com.example.socialmediaplatform.model.UserModel;
import com.example.socialmediaplatform.service.UserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    @NonNull
    private final UserService userService;

    // Retrieve a user profile by ID
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserModel> getUser(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(new UserModel(userService.getUser(id)));
    }

    // Register a new user
    /*@PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserModel> registerUser(@RequestBody UserRegisterRequest request) {
        User registeredUser = userService.registerUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(new UserModel(registeredUser));
    }

    // Authenticate a user and generate a JWT
    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JwtResponse> loginUser(@RequestBody UserLoginRequest request) {
        JwtResponse jwtResponse = userService.loginUser(request);
        return ResponseEntity.ok(jwtResponse);
    }

    // Follow a user
    @PostMapping(value = "/{id}/follow", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> followUser(@PathVariable(value = "id") Long id, @RequestBody FollowRequest request) {
        userService.followUser(id, request.getFollowerId());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    // Search for users based on keywords
    @PostMapping(value = "/search", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserModel>> searchUsers(@RequestBody UserSearchRequest request) {
        List<UserModel> users = userService.searchUsers(request.getKeyword(), request.getPage(), request.getSize()).stream().map(UserModel::new).collect(Collectors.toList());
        return ResponseEntity.ok(users);
    }*/
}

