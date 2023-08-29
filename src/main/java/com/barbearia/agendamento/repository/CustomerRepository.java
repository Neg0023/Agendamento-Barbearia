package com.barbearia.agendamento.repository;

import com.barbearia.agendamento.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {
}
