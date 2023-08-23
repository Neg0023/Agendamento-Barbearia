package com.barbearia.agendamento.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record UsersDTO(
        String id,
        @NotBlank
        @Email
        String email,
        @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()])(?=.{8,16}).*$")
        String password) {
}
