package com.example.socialmediaplatform.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@RequiredArgsConstructor
public class PostModel {

    private Long webId;
    private String content;
    private Date timeStamp;
    private Long likes;
    private UserModel userModel;
    private List<CommentModel> commentModels;



}
