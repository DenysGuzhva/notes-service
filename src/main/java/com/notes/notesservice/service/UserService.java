package com.notes.notesservice.service;

import com.notes.notesservice.entity.UserEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService {

  UserEntity loadUserByUsername(String username) throws UsernameNotFoundException;

}
