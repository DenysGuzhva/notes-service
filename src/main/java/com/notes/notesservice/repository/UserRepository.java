package com.notes.notesservice.repository;

import com.notes.notesservice.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserEntity, String> {

  UserEntity findByUsername(String username);
}
