package com.notes.notesservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "like")
@AllArgsConstructor
public class LikeEntity {

  @Id
  private String id;
  private String likingUserId;
  private String likedNoteId;

}
