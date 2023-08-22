package com.barbearia.agendamento.repository;

import com.barbearia.agendamento.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
