package com.barbearia.agendamento.repository;

import com.barbearia.agendamento.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CustomerRepository extends MongoRepository<Customer, String> {
    Optional<Customer> findByCpf(String cpf);
}
