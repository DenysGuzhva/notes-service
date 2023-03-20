package com.notes.notesservice.controller;

import com.notes.notesservice.dto.NoteRequest;
import com.notes.notesservice.entity.NoteEntity;
import com.notes.notesservice.service.NoteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/notes")
@AllArgsConstructor
public class NotesController {

  private final NoteService noteService;

  @PostMapping("/create")
  public ResponseEntity<?> createNewNote(@RequestBody NoteRequest note) {
    return ResponseEntity.ok(noteService.createNewNote(note));
  }

  @PostMapping("/update")
  public ResponseEntity<?> update(@RequestBody NoteEntity note) {
    return ResponseEntity.ok(noteService.update(note));
  }

  //TODO change userId to authToken
  @GetMapping("/all")
  public ResponseEntity<?> getAll(@RequestParam(name = "userId", required = false) String userId) {
    return ResponseEntity.ok(noteService.findAllByUserId(userId));
  }

  @DeleteMapping()
  public void deleteNote(@RequestParam(name = "id") String noteId) {
    noteService.deleteById(noteId);
  }

}
