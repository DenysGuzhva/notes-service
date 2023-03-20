package com.notes.notesservice.controller;

import com.notes.notesservice.service.LikeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/like")
@AllArgsConstructor
public class LikeController {

  private final LikeService likeService;
  //TODO auth
  @PostMapping("/")
  public void like(@RequestParam(name = "userId")String likingUserId, @RequestParam(name = "noteId")String likedNoteId) {
    likeService.likeNote(likingUserId, likedNoteId);
  }

}
