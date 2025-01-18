package com.example.socialmediaplatform.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "comments", schema = "social")
@Setter
@Getter
@RequiredArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="web_id")
    private Long webId;

    @Column(name="content")
    private String content;

    @Column(name="time_stamp", updatable = false)
    /*todo:
    @Temporal(TemporalType.TIMESTAMP)*/
    private Date timeStamp;

    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name="post_id", nullable = false)
    private Post post;

}
