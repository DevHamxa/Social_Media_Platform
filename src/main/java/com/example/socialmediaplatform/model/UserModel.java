package com.example.socialmediaplatform.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@RequiredArgsConstructor
public class UserModel {

    private Long webId;
    private String userName;
    private String email;
    private String password;
    private byte[] profilePicture;
    private String bioDescription;
    private List<PostModel> postModels;
    private Set<UserModel> following = new HashSet<>();
    private Set<UserModel> followers = new HashSet<>();

}
