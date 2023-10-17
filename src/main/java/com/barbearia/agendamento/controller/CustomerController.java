package com.barbearia.agendamento.controller;

import com.barbearia.agendamento.Exception.ClienteNaoExiste;
import com.barbearia.agendamento.dto.CustomerDTO;
import com.barbearia.agendamento.model.Customer;
import com.barbearia.agendamento.repository.CustomerRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/customer")
@Slf4j
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

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> getRegister(@PathVariable String id){
        var customer = repository.findById(id).orElseThrow(() -> new ClienteNaoExiste("Cliente não existe"));
        return ResponseEntity.ok(customer);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Customer>> getAllRegister(){
        var listCustomer = repository.findAll();
        return ResponseEntity.ok().body(listCustomer);
    }
}
