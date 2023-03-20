package com.notes.notesservice.service.serviceImpl;

import com.notes.notesservice.dto.Note;
import com.notes.notesservice.dto.NoteRequest;
import com.notes.notesservice.entity.NoteEntity;
import com.notes.notesservice.mapper.NoteMapper;
import com.notes.notesservice.repository.LikeRepository;
import com.notes.notesservice.repository.NotesRepository;
import com.notes.notesservice.service.NoteService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NoteServiceImpl implements NoteService {

  private final NoteMapper mapper;
  private final NotesRepository notesRepository;
  private final LikeRepository likeRepository;

  @Override
  public NoteEntity createNewNote(NoteRequest note) {
    return notesRepository.save(mapper.requestToEntity(note));
  }

  @Override
  public List<Note> findAll() {
    return mapper.mapAllEntitiesToNote(notesRepository.findAllByOrderByDateCreatedDesc());
  }

  @Override
  public List<Note> findAllByUserId(String userId) {
    return mapper.mapAllEntitiesToNote(notesRepository.findAllByUserIdOrderByDateCreatedDesc(userId));
  }

  @Override
  public void deleteById(String id) {
    notesRepository.deleteById(id);
    likeRepository.deleteAllByLikedNoteId(id);
  }

  @Override
  public Note update(NoteEntity entity) {
    return mapper.mapEntityToNote(notesRepository.save(entity));
  }

}
