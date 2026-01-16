package my.pet.Pet_NotesAPI_BackEnd.dto.responce;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Data
@Getter
@Schema(name = "Информационное сообщение о статусе")
public class StatusDTO {
    @Schema(
            title = "HTTP статус"
    )
    private final HttpStatus status;

    @Schema(
            title = "Расширенное текстовое описание статуса и подробное описание возникших проблем"
    )
    private final String message;
}
