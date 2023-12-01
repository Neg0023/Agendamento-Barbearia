package com.barbearia.agendamento.Exception;

import com.barbearia.agendamento.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExeptionHandlerRequest{

    @ExceptionHandler(HorarioExiste.class)
    public ResponseEntity<ErrorDto> badRequest(HorarioExiste ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                ErrorDto.builder()
                        .error(ex.getMessage())
                        .code(HttpStatus.BAD_REQUEST.value())
                        .build()
        );
    }

    @ExceptionHandler(ClienteNaoExiste.class)
    public ResponseEntity<ErrorDto> notFound(ClienteNaoExiste ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                ErrorDto.builder()
                        .error(ex.getMessage())
                        .code(HttpStatus.NOT_FOUND.value())
                        .build()
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> badRequest(MethodArgumentNotValidException ex){
        Map<String, String> messages = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach(error -> {
            String field = ((FieldError) error).getField();
            String defaultMessage = error.getDefaultMessage();
            messages.put(field, defaultMessage);
        });

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(messages);
    }
}