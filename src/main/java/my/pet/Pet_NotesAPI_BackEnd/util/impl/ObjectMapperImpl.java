package my.pet.Pet_NotesAPI_BackEnd.util.impl;

import my.pet.Pet_NotesAPI_BackEnd.dto.responce.NoteDTO;
import my.pet.Pet_NotesAPI_BackEnd.model.Note;
import my.pet.Pet_NotesAPI_BackEnd.util.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class ObjectMapperImpl implements ObjectMapper {


    @Override
    public NoteDTO mapToDTO(Note note) {
        return NoteDTO.builder()
                .id(note.getId())
                .title(note.getTitle())
                .content(note.getContent())
                .createdAt(note.getCreatedAt())
                .updatedAt(note.getUpdatedAt())
                .build();
    }


}
