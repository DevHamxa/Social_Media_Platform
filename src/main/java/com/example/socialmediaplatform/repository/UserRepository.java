package com.example.socialmediaplatform.repository;

import com.example.socialmediaplatform.domain.User;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByWebId(Long userId);

    User findByEmail(String email);
}
