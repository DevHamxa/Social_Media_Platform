package com.example.socialmediaplatform.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    private final CustomUserDetailsService userDetailsService;
    private final JwtRequestFilter jwtRequestFilter;

    public SecurityConfig(CustomUserDetailsService userDetailsService, JwtRequestFilter jwtRequestFilter) {
        this.userDetailsService = userDetailsService;
        this.jwtRequestFilter = jwtRequestFilter;
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {

        AuthenticationManagerBuilder authManagerBuilder =  http.getSharedObject(AuthenticationManagerBuilder.class);
        authManagerBuilder.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
        return authManagerBuilder.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers("/api/auth/login", "/users/signup") // Disable CSRF for the login API endpoint
                )
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/blog/**", "/api/auth/login", "/users/signup").permitAll() // Allow public access to blog
                        .anyRequest().authenticated() // Require authentication for other requests
                )
                .formLogin(formLogin -> formLogin
                        .loginPage("/api/auth/login") // Ensure this is correctly set
                        .failureUrl("/api/auth/login?error")
                        .permitAll()
                        //.defaultSuccessUrl("/users/1", true) // Specify where to redirect after successful login
                )
                .rememberMe(Customizer.withDefaults());

        return http.build();
    }

}

