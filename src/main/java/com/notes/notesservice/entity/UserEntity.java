package com.notes.notesservice.entity;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Data
@Document(collection = "user")
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

  @Id
  private String id;
  private String username;
  private String password;
  private String role;
  private List<SimpleGrantedAuthority> authorities;

}
