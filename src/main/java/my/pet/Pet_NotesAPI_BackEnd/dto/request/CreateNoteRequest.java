package my.pet.Pet_NotesAPI_BackEnd.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Schema(name = "Данные создаваемой заметки")
public class CreateNoteRequest {

    @Schema(
            requiredMode = Schema.RequiredMode.REQUIRED,
            title = "Название заметки"
    )
    private String title;

    @Schema(
            title = "Расширенное описание заметки, добавляемой в контекст приложения",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private String content;


}
