package com.barbearia.agendamento.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ErrorDto {

    private String error;
    private Integer code;
}
