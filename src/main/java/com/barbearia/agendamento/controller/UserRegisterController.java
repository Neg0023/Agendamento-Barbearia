package com.barbearia.agendamento.controller;

import com.barbearia.agendamento.dto.UsersDTO;
import com.barbearia.agendamento.model.User;
import com.barbearia.agendamento.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/register")
public class UserRegisterController {

    @Autowired
    private UserRepository repository;

    @PostMapping
    public ResponseEntity register(@RequestBody @Valid UsersDTO data, UriComponentsBuilder uriComponentsBuilder) {

        var user = new User(data.getEmail(), data.getPassword());
        repository.save(user);
        var uri = uriComponentsBuilder.path("register/{id}").buildAndExpand(user.getId()).toUri();

        return ResponseEntity.created(uri).body(user);
    }
}
