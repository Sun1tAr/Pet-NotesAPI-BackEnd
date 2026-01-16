package my.pet.Pet_NotesAPI_BackEnd.util;


import my.pet.Pet_NotesAPI_BackEnd.dto.responce.NoteDTO;
import my.pet.Pet_NotesAPI_BackEnd.model.Note;

public interface ObjectMapper {


    NoteDTO mapToDTO(Note note);

}
