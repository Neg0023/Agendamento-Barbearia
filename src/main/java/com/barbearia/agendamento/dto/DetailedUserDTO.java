package com.barbearia.agendamento.dto;

import com.barbearia.agendamento.model.User;

public record DetailedUserDTO(String email) {

    public DetailedUserDTO(User user) {
        this(user.getEmail());
    }
}
