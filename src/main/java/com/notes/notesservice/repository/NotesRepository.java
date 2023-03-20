package com.notes.notesservice.repository;

import com.notes.notesservice.entity.NoteEntity;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotesRepository extends MongoRepository<NoteEntity, String> {

  @Override
  <S extends NoteEntity> S save(S entity);

  @Override
  List<NoteEntity> findAll();

  List<NoteEntity> findAllByOrderByDateCreatedDesc();

  List<NoteEntity> findAllByUserIdOrderByDateCreatedDesc(String userId);


}
