package com.barbearia.agendamento.Exception;

import com.barbearia.agendamento.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExeptionHandlerRequest{

    @ExceptionHandler(ClienteNaoExiste.class)
    public ResponseEntity<ErrorDto> badRequest(ClienteNaoExiste ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                ErrorDto.builder()
                        .error(ex.getMessage())
                        .code(HttpStatus.BAD_REQUEST.value())
                        .build()
        );
    }
}
