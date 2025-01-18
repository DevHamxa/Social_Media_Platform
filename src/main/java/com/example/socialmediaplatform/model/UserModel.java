package com.example.socialmediaplatform.model;

import com.example.socialmediaplatform.domain.Follow;
import com.example.socialmediaplatform.domain.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Setter
@Getter
@RequiredArgsConstructor
public class UserModel {

    private Long webId;
    private String userName;
    private String email;
    private byte[] profilePicture;
    private String bioDescription;
    private List<PostModel> postModels;
    private List<FollowModel> followers;
    private List<FollowModel> following;

    public UserModel(User user) {
        this.webId = user.getWebId();
        this.userName = user.getUserName();
        this.email = user.getEmail();
        this.profilePicture = user.getProfilePicture();
        this.bioDescription = user.getBioDescription();
        this.followers = user.getFollowers().stream().map(FollowModel::getUserFollowers).collect(Collectors.toList());
        this.following = user.getFollowing().stream().map(FollowModel::getFollowingsOfUser).collect(Collectors.toList());
    }



}
