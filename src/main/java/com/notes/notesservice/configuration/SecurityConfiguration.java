package com.notes.notesservice.configuration;

import com.notes.notesservice.entity.UserEntity;
import com.notes.notesservice.repository.UserRepository;
import com.notes.notesservice.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public UserService userService(UserRepository userRepository) {
    return username -> {
      UserEntity user = userRepository.findByUsername(username);
      if (user != null) {
        return user;
      }
      throw new UsernameNotFoundException("User " + username + " not found!");
    };
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    return http
        .authorizeHttpRequests()
        .requestMatchers("/api/v1/notes").permitAll()

        .requestMatchers("/api/v1/notes").hasRole("user")
        .requestMatchers("/api/v1/user/create").permitAll()
        .and().build();
  }

}
