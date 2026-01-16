package my.pet.Pet_NotesAPI_BackEnd.service;


import my.pet.Pet_NotesAPI_BackEnd.dto.request.CreateNoteRequest;
import my.pet.Pet_NotesAPI_BackEnd.model.Note;

public interface NoteService {

    Note createNote(CreateNoteRequest noteRequest);

    Note getNoteById(Long id);

}
