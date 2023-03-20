package com.notes.notesservice.repository;

import com.notes.notesservice.entity.LikeEntity;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends MongoRepository<LikeEntity, String> {

  @Override
  void deleteById(String s);

  LikeEntity findByLikingUserIdAndLikedNoteId(String likedUserId, String likedNoteId);

  void deleteAllByLikedNoteId(String likedId);

  List<LikeEntity> findAllByLikedNoteId(String likedNoteId);

}
