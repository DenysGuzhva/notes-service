package com.notes.notesservice.mapper;

import com.notes.notesservice.dto.Note;
import com.notes.notesservice.dto.NoteRequest;
import com.notes.notesservice.entity.LikeEntity;
import com.notes.notesservice.entity.NoteEntity;
import com.notes.notesservice.repository.LikeRepository;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NoteMapper {

  private final LikeRepository likeRepository;

  public Note mapEntityToNote(NoteEntity entity) {
    return new Note(
        entity.getId(),
        entity.getUserId(),
        entity.getText(),
        entity.getDateCreated(),
        likeRepository.findAllByLikedNoteId(entity.getId()));
  }

  public List<Note> mapAllEntitiesToNote(List<NoteEntity> notes) {
    return notes.stream().map(this::mapEntityToNote).collect(Collectors.toList());
  }

  public NoteEntity requestToEntity(NoteRequest noteRequest) {
    return new NoteEntity(
        null,
        noteRequest.getUserId() == null ? UUID.randomUUID().toString() : noteRequest.getUserId(),
        noteRequest.getText(),
        noteRequest.getDateCreated());
  }

}
