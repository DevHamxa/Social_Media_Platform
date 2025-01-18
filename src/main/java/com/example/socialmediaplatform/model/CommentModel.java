package com.example.socialmediaplatform.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@RequiredArgsConstructor
public class CommentModel {

    private Long webId;
    private String content;
    private Date timeStamp;
    private UserModel userModel;
    private PostModel postModel;

}
