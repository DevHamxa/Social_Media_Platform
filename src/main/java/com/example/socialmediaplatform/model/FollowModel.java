package com.example.socialmediaplatform.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@RequiredArgsConstructor
public class FollowModel {

    private Long webId;
    private UserModel follower;
    private UserModel followed;
    private Date followDate;

}
