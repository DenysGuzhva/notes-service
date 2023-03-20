package com.notes.notesservice.dto;

import com.notes.notesservice.entity.LikeEntity;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Note {

  private String id;
  private String userId;
  private String text;
  private LocalDateTime dateCreated;
  private List<LikeEntity> likes;



}
