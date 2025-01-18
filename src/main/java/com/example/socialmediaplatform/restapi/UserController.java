package com.example.socialmediaplatform.restapi;

import com.example.socialmediaplatform.domain.User;
import com.example.socialmediaplatform.model.UserModel;
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
    public ResponseEntity<UserModel> getUser(@PathVariable(value="id") Long id) {
        return ResponseEntity.ok(new UserModel(userService.getUser(id)));
    }


}
