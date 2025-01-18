package com.example.socialmediaplatform.restapi;

import com.example.socialmediaplatform.domain.User;
import com.example.socialmediaplatform.service.UserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")

public class UserController {

    @NonNull
    private final UserService userService;

    @GetMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUser(@PathVariable(value="id") Long id) {
        return ResponseEntity.ok(userService.getUser(id));
    }


}
