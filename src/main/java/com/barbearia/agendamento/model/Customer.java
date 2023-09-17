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
    private String telefone;
    private String sobreNome;
    private String email;
    private String cep;
    private String logradouro;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;

    public Customer(CustomerDTO data) {
        this.name = data.nome();
        this.cpf = data.cpf();
        this.telefone = data.telefone();
        this.sobreNome = data.sobreNome();
        this.email = data.email();
        this.cep = data.cep();
        this.logradouro = data.logradouro();
        this.numero = data.numero();
        this.bairro = data.bairro();
        this.cidade = data.cidade();
        this.estado = data.estado();
    }
}
