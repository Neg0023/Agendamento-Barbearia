package com.barbearia.agendamento.model;

import com.barbearia.agendamento.dto.UsersDTO;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {

    @Id
    private String id;
    private String email;
    private String password;

    public User(UsersDTO data) {
        this.email = data.email();
        this.password = data.password();
    }
}
