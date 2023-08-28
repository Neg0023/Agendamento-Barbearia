package com.barbearia.agendamento.controller;

import com.barbearia.agendamento.dto.UsersDTO;
import com.barbearia.agendamento.model.User;
import com.barbearia.agendamento.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class UserRegisterController {

    @Autowired
    private UserRepository repository;

    @PostMapping
    public void register(@RequestBody @Valid UsersDTO data) {
        repository.save(new User(data));
    }
}
