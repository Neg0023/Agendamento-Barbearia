package com.barbearia.agendamento.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document(collection = "agendamento")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Agendamento {

    @Id
    private String id;
    private String cpf;
    private String nome;
    private String horario;
    private String formaPagamento;
    private String statusPagamento;
}
