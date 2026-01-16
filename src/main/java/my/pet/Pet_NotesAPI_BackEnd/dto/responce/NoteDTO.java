package my.pet.Pet_NotesAPI_BackEnd.dto.responce;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;


@Builder
@Getter
@Schema(name = "Данные существующей заметки")
public class NoteDTO {

    @Schema(
            title =  "Уникальный идентификатор заметки"
    )
    private Long id;

    @Schema(
            title = "Название заметки"
    )
    private String title;

    @Schema(
            title = "Расширенное описание заметки, добавляемой в контекст приложения"
    )
    private String content;

    @Schema(
            title = "Дата и время создания заметки",
            pattern = "yyyy-MM-dd[T]hh:mm:ss:ms"
    )
    @JsonFormat(shape = Shape.STRING)
    private LocalDateTime createdAt;


    @Schema(
            title = "Дата и время изменения заметки",
            pattern = "yyyy-MM-dd[T]hh:mm:ss:ms"
    )
    @JsonFormat(shape = Shape.STRING)
    private LocalDateTime updatedAt;

}
