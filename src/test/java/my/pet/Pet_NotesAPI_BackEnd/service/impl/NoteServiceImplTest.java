package my.pet.Pet_NotesAPI_BackEnd.service.impl;

import my.pet.Pet_NotesAPI_BackEnd.dto.request.CreateNoteRequest;
import my.pet.Pet_NotesAPI_BackEnd.exception.NotFoundException;
import my.pet.Pet_NotesAPI_BackEnd.model.Note;
import my.pet.Pet_NotesAPI_BackEnd.repository.NoteRepository;
import my.pet.Pet_NotesAPI_BackEnd.service.NoteService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class NoteServiceImplTest {

    @Mock
    private NoteRepository repository;

    @InjectMocks
    private NoteServiceImpl service;

    final String TITLE = "Note title";
    final String DESC = "Extends note`s description";
    final Random random = new Random();


    @Test
    public void test_createNote_noteSuccessfullyCreated() {
        // Given
        CreateNoteRequest request = new CreateNoteRequest();
        request.setTitle(TITLE);
        request.setContent(DESC);

        when(repository.save(any(Note.class))).thenAnswer(invocation -> {
            Note arg = invocation.getArgument(0);
            arg.setId(random.nextLong(1, 100));
            return arg;
        });

        // When
        Note note = service.createNote(request);

        // Then
        assertNotNull(note);
        assertNotNull(note.getId());
        assertEquals(request.getTitle(), note.getTitle());
        assertEquals(request.getContent(), note.getContent());
    }


    @Test
    public void test_getNoteById_noteWasFound() {
        // Given
        Long id = 1L;

        Note returnableNote = Note.builder()
                .id(id)
                .title(TITLE)
                .content(DESC)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        when(repository.findById(id)).thenReturn(Optional.of(returnableNote));

        // When
        Note noteById = service.getNoteById(id);

        // Then
        assertNotNull(noteById);
        assertEquals(returnableNote.getTitle(), noteById.getTitle());
        assertEquals(returnableNote.getContent(), noteById.getContent());
    }


    @Test
    public void test_getNoteById_noteNotFoundAndThrowedException() {
        // Given
        when(repository.findById(9999L)).thenReturn(Optional.empty());

        // When
        Exception throwed = null;
        try {
            service.getNoteById(9999L);
        } catch (Exception e) {
            throwed = e;
        }

        // Then
        assertNotNull(throwed);
        assertInstanceOf(NotFoundException.class, throwed);
        NotFoundException notFoundException = (NotFoundException) throwed;

        assertNotNull(notFoundException.getMessage());
    }








}