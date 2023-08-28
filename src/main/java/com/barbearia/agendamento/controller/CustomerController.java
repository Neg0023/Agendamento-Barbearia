package com.barbearia.agendamento.controller;

import com.barbearia.agendamento.dto.CustomerDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @PostMapping
    public void register(@RequestBody @Valid CustomerDTO data){
        System.out.println(data);
    }
}
