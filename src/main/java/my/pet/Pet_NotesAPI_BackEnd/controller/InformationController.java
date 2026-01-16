package my.pet.Pet_NotesAPI_BackEnd.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import my.pet.Pet_NotesAPI_BackEnd.dto.responce.StatusDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public interface InformationController {

    @Operation(
            summary = "Проверка здоровья сервера (API)",
            description = "Возвращение пустого сообщения гарантирует работоспособность сервера",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Сервер готов к работе с указанными данными",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = StatusDTO.class),
                                    examples = {@ExampleObject(
                                            value = "{\n" +
                                                    "  \"status\": \"200 OK\",\n" +
                                                    "  \"message\": \"\"\n" +
                                                    "}"
                                    )}
                            )
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Работоспособность сервера нарушена по неизвестным причинам",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = StatusDTO.class),
                                    examples = {@ExampleObject(
                                            value = "{\n" +
                                                    "  \"status\": \"500 INTERNAL_SERVER_ERROR\",\n" +
                                                    "  \"message\": \"Invalid request entity\"\n" +
                                                    "}"
                                    )}
                            )
                    )
            }
    )
    @GetMapping("/health")
    default ResponseEntity<StatusDTO> getHealth() {
        return new ResponseEntity<>(
                new StatusDTO(HttpStatus.OK, ""),
                HttpStatus.OK
        );
    }


    @Operation(
            summary = "Проверка корректности работы сервера (API)",
            description = "Возвращение \"pong\" сообщения гарантирует корректную работу сервера",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Сервер готов к работе с указанными данными",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = StatusDTO.class),
                                    examples = {@ExampleObject(
                                            value = "{\n" +
                                                    "  \"status\": \"200 OK\",\n" +
                                                    "  \"message\": \"Pong\"\n" +
                                                    "}"
                                    )}
                            )
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Работоспособность сервера нарушена по неизвестным причинам",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = StatusDTO.class),
                                    examples = {@ExampleObject(
                                            value = "{\n" +
                                                    "  \"status\": \"500 INTERNAL_SERVER_ERROR\",\n" +
                                                    "  \"message\": \"Invalid request entity\"\n" +
                                                    "}"
                                    )}
                            )
                    )
            }
    )
    @GetMapping("/ping")
    default ResponseEntity<StatusDTO> ping() {
        return new ResponseEntity<>(
                new StatusDTO(HttpStatus.OK, "Pong"),
                HttpStatus.OK
        );
    }

}
