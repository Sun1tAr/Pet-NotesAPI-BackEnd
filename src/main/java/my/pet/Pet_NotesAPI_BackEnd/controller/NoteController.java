package my.pet.Pet_NotesAPI_BackEnd.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import my.pet.Pet_NotesAPI_BackEnd.dto.request.CreateNoteRequest;
import my.pet.Pet_NotesAPI_BackEnd.dto.responce.NoteDTO;
import my.pet.Pet_NotesAPI_BackEnd.model.Note;
import my.pet.Pet_NotesAPI_BackEnd.service.NoteService;
import my.pet.Pet_NotesAPI_BackEnd.util.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Tag(
        name = "Notes API",
        description = "Notes API предназначено для работы с таким ресурсом как 'Заметка'"
)
@RestController
@RequestMapping("/notes")
@RequiredArgsConstructor
public class NoteController implements InformationController {

    private final NoteService noteService;
    private final ObjectMapper mapper;

    @Operation(
            summary = "Создание новой заметки",
            description = "Метод позволяет создать новую заметку и при успешном создании возвращает ее данные",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Данные созданной заметки",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = NoteDTO.class),
                                    examples = {
                                            @ExampleObject(
                                                    value = "{\n" +
                                                            "  \"content\": \"Расширенное описание новой заметки\",\n" +
                                                            "  \"createdAt\": \"2026-01-16T16:40:58.2897196\",\n" +
                                                            "  \"id\": 1,\n" +
                                                            "  \"title\": \"Новая заметка\",\n" +
                                                            "  \"updatedAt\": \"2026-01-16T16:40:58.2897196\"\n" +
                                                            "}"
                                            )
                                    }
                            )
                    )
            },
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Данные на основе которых создается заметка",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = CreateNoteRequest.class),
                            examples = {
                                    @ExampleObject(
                                            value = "{\n" +
                                                    "  \"title\": \"Новая заметка\",\n" +
                                                    "  \"content\": \"Расширенное описание новой заметки\"\n" +
                                                    "}"
                                    )
                            }
                    )
            )
    )
    @PostMapping
    public ResponseEntity<NoteDTO> createNote(@Valid @RequestBody CreateNoteRequest noteRequest) {
        Note note = noteService.createNote(noteRequest);

        NoteDTO noteDTO = mapper.mapToDTO(note);

        return new ResponseEntity<>(noteDTO, HttpStatus.CREATED);
    }


    @Operation(
            summary = "Получение заметки по её id",
            description = "Метод позволяет получить заметку, если известен ее уникальный идентификатор",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Данные заметки из контекста приложения",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = NoteDTO.class),
                                    examples = {
                                            @ExampleObject(
                                                    value = "{\n" +
                                                            "  \"content\": \"Расширенное описание новой заметки\",\n" +
                                                            "  \"createdAt\": \"2026-01-16T16:40:58.2897196\",\n" +
                                                            "  \"id\": 1,\n" +
                                                            "  \"title\": \"Новая заметка\",\n" +
                                                            "  \"updatedAt\": \"2026-01-16T16:40:58.2897196\"\n" +
                                                            "}"
                                            )
                                    }
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Заметка (еще или уже) не существует в контексте приложения",
                            content = @Content()
                    )
            },
            parameters = {
                    @Parameter(
                            name = "id",
                            description = "Уникальный идентификатор заметки в контексте приложения",
                            required = true
                    )
            }
    )
    @GetMapping("/{id}")
    public ResponseEntity<NoteDTO> getNoteById(@PathVariable(name = "id") Long id) {
        Note note = noteService.getNoteById(id);
        NoteDTO noteDTO = mapper.mapToDTO(note);
        return new ResponseEntity<>(noteDTO, HttpStatus.OK);
    }










}
