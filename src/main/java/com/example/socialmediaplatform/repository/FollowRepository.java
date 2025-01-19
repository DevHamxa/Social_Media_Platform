package com.example.socialmediaplatform.repository;

import com.example.socialmediaplatform.domain.Follow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowRepository extends JpaRepository<Follow,Long> {

    @Query(nativeQuery = true, value = "Select * from follows where followed_id = :userId")
    List<Follow> findAllByFollowedId(Long userId);

    @Query(nativeQuery = true, value = "Select * from follows where follower_id = :userId")
    List<Follow> findAllByFollowerId(Long userId);
}
