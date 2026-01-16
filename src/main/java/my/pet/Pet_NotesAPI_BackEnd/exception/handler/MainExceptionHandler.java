package my.pet.Pet_NotesAPI_BackEnd.exception.handler;

import lombok.extern.slf4j.Slf4j;
import my.pet.Pet_NotesAPI_BackEnd.dto.responce.StatusDTO;
import my.pet.Pet_NotesAPI_BackEnd.exception.AppException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@Slf4j
public class MainExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<StatusDTO> handleException(AppException e) {
        log.warn(e.getMessage());
        StatusDTO st = new StatusDTO(e.getStatus(), e.getMessage());
        return new ResponseEntity<>(st, e.getStatus());
    }

    @ExceptionHandler
    public ResponseEntity<Object> handleException(Exception e) {
        log.error(e.getMessage());
        StatusDTO st = new StatusDTO(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        return new ResponseEntity<>(st, st.getStatus());
    }



}
