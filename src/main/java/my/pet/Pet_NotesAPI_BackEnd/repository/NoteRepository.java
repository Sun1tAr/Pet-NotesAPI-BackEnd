package my.pet.Pet_NotesAPI_BackEnd.repository;

import my.pet.Pet_NotesAPI_BackEnd.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
}
