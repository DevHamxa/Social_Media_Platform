package com.example.socialmediaplatform.auth;


import com.example.socialmediaplatform.config.JwtService;
import com.example.socialmediaplatform.model.UserModel;
import com.example.socialmediaplatform.repository.UserRepository;

import com.example.socialmediaplatform.utils.ResourceAlreadyExistsException;
import com.example.socialmediaplatform.utils.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
  private final UserRepository repository;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;

  public AuthenticationResponse register(UserModel userModel) {
    userModel.setPassword(passwordEncoder.encode(userModel.getPassword()));
    var user = userModel.assemble();
    var userCheck = repository.findByEmail(userModel.getEmail());
    if (!ObjectUtils.isEmpty(userCheck)) {
      throw new ResourceAlreadyExistsException();
    }
    var savedUser = repository.save(user);
    var jwtToken = jwtService.generateToken(user);
    return AuthenticationResponse.builder()
        .accessToken(jwtToken)
        .build();
  }

  public AuthenticationResponse authenticate(UserModel userModel) {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
                userModel.getEmail(),
                userModel.getPassword()
        )
    );
    var user = repository.findByEmail(userModel.getEmail());
    if (ObjectUtils.isEmpty(user)) {
      throw new ResourceNotFoundException();
    }

    var jwtToken = jwtService.generateToken(user);
    return AuthenticationResponse.builder()
        .accessToken(jwtToken)
        .build();
  }

}
