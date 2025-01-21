package com.example.socialmediaplatform.model;

import com.example.socialmediaplatform.domain.Follow;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@RequiredArgsConstructor
public class FollowModel {

    private Long webId;
    private String userName;
    private String email;
    private byte[] profilePicture;
    private String bioDescription;
    private Date followDate;

    public static FollowModel getUserFollowers(Follow follow) {
        FollowModel followModel = new FollowModel();
        followModel.webId = follow.getWebId();
        followModel.userName = follow.getFollower().getName();
        followModel.email = follow.getFollower().getEmail();
        followModel.profilePicture = follow.getFollower().getProfilePicture();
        followModel.bioDescription = follow.getFollower().getBioDescription();
        followModel.followDate = follow.getFollowDate();
        return followModel;
    }

    public static FollowModel getFollowingsOfUser(Follow follow) {
        FollowModel followModel = new FollowModel();
        followModel.webId = follow.getWebId();
        followModel.userName = follow.getFollowed().getName();
        followModel.email = follow.getFollowed().getEmail();
        followModel.profilePicture = follow.getFollowed().getProfilePicture();
        followModel.bioDescription = follow.getFollowed().getBioDescription();
        followModel.followDate = follow.getFollowDate();
        return followModel;
    }

}
