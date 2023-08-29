package com.barbearia.agendamento.model;

import com.barbearia.agendamento.dto.CustomerDTO;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customer")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Customer {

    @Id
    private String id;
    private String name;
    private String cpf;
    private String phoneNumber;

    public Customer(CustomerDTO data) {
        this.name = data.name();
        this.cpf = data.cpf();
        this.phoneNumber = data.phoneNumber();
    }
}
