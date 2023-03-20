package com.notes.notesservice.service.serviceImpl;

import com.notes.notesservice.entity.LikeEntity;
import com.notes.notesservice.repository.LikeRepository;
import com.notes.notesservice.service.LikeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LikedServiceImpl implements LikeService {

  private final LikeRepository likeRepository;

  @Override
  public void likeNote(String likedUserId, String likedNoteId) {
    LikeEntity like = likeRepository.findByLikingUserIdAndLikedNoteId(likedUserId, likedNoteId);
    if (like == null) {
      likeRepository.save(new LikeEntity(null, likedUserId, likedNoteId));
    } else {
      likeRepository.deleteById(like.getId());
    }
  }

}
