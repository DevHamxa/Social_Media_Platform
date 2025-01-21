package com.example.socialmediaplatform.model;

import com.example.socialmediaplatform.domain.Follow;
import com.example.socialmediaplatform.domain.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.util.ObjectUtils;

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
    private String password;
    private byte[] profilePicture;
    private String bioDescription;
    private List<PostModel> postModels;
    private List<FollowModel> followers;
    private List<FollowModel> following;

    public UserModel(User user) {
        this.webId = user.getWebId();
        this.userName = user.getName();
        this.password = user.getPassword();
        this.email = user.getEmail();
        this.profilePicture = user.getProfilePicture();
        this.bioDescription = user.getBioDescription();
        this.followers = !ObjectUtils.isEmpty(user.getFollowers()) ? user.getFollowers().stream().map(FollowModel::getUserFollowers).collect(Collectors.toList()): null;
        this.following = !ObjectUtils.isEmpty(user.getFollowing()) ? user.getFollowing().stream().map(FollowModel::getFollowingsOfUser).collect(Collectors.toList()): null;
    }


    public UserModel(String email, String encodedPassword) {
        this.email = email;
        this.password = encodedPassword;
    }

    public User assemble() {
        User user = new User();
        user.setEmail(this.email);
        user.setPassword(this.password);
        return user;
    }
}
