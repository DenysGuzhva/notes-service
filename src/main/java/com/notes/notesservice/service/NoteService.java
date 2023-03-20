package com.notes.notesservice.service;

import com.notes.notesservice.dto.Note;
import com.notes.notesservice.dto.NoteRequest;
import com.notes.notesservice.entity.NoteEntity;
import java.util.List;

public interface NoteService {

  NoteEntity createNewNote(NoteRequest note);

  List<Note> findAll();

  List<Note> findAllByUserId(String userId);

  void deleteById(String id);

  Note update(NoteEntity entity);

}
