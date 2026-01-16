package my.pet.Pet_NotesAPI_BackEnd.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import my.pet.Pet_NotesAPI_BackEnd.dto.request.CreateNoteRequest;
import my.pet.Pet_NotesAPI_BackEnd.exception.NotFoundException;
import my.pet.Pet_NotesAPI_BackEnd.model.Note;
import my.pet.Pet_NotesAPI_BackEnd.repository.NoteRepository;
import my.pet.Pet_NotesAPI_BackEnd.service.NoteService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;


    @Override
    public Note createNote(CreateNoteRequest noteRequest) {
        Note note = Note.builder()
                .title(noteRequest.getTitle())
                .content(noteRequest.getContent())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
        return noteRepository.save(note);
    }

    @Override
    public Note getNoteById(Long id) {
        Optional<Note> note = noteRepository.findById(id);
        if (note.isEmpty()) {
            throw new NotFoundException("Note was not found");
        }
        return note.get();
    }
}
