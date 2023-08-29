package com.barbearia.agendamento.controller;

import com.barbearia.agendamento.dto.CustomerDTO;
import com.barbearia.agendamento.model.Customer;
import com.barbearia.agendamento.repository.CustomerRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerRepository repository;

    @PostMapping
    public void register(@RequestBody @Valid CustomerDTO data){
        repository.save(new Customer(data));
    }
}
