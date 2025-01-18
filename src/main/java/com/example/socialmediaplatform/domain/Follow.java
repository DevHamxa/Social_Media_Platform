package com.example.socialmediaplatform.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "follows", schema = "social")
@Setter
@Getter
@RequiredArgsConstructor
public class Follow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="web_id")
    private Long webId;

    @ManyToOne
    @JoinColumn(name = "follower_id", nullable = false)
    private User follower;

    @ManyToOne
    @JoinColumn(name = "followed_id", nullable = false)
    private User followed;

    @Column(name = "follow_date", nullable = false, updatable = false)
    /*todo:
    @Temporal(TemporalType.TIMESTAMP)*/
    private Date followDate;

}
