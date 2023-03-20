package com.notes.notesservice.entity;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "note")
@AllArgsConstructor
public class NoteEntity {

  @Id
  private String id;
  private String userId;
  private String text;
  private LocalDateTime dateCreated;

}
