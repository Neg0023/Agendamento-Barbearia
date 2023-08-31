package com.barbearia.agendamento.controller;

import com.barbearia.agendamento.dto.CustomerDTO;
import com.barbearia.agendamento.model.Customer;
import com.barbearia.agendamento.repository.CustomerRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerRepository repository;

    @PostMapping
    public ResponseEntity register(@RequestBody @Valid CustomerDTO data, UriComponentsBuilder uriComponentsBuilder){
        var customer = new Customer(data);
        repository.save(customer);
        var uri = uriComponentsBuilder.path("customer/{id}").buildAndExpand(customer.getId()).toUri();

        return ResponseEntity.created(uri).body(customer);
    }
}
