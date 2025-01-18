package com.example.socialmediaplatform.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "posts", schema = "social")
@Setter
@Getter
@RequiredArgsConstructor
public class Post {

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

    @Column(name="likes")
    private Long likes;

    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments;



}
