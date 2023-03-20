package com.notes.notesservice.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NoteRequest {

  private String userId;
  private String text;
  private LocalDateTime dateCreated;

}
