package com.barbearia.agendamento.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AgendamentoModel {

    @NotNull(message = "Campo não pode ser vazio")
    @CPF
    private String cpf;
    @NotNull(message = "Campo não pode ser vazio")
    private String horario;
    @NotNull(message = "Campo não pode ser vazio")
    private String formaPagamento;
    @NotNull(message = "Campo não pode ser vazio")
    private String statusPagamento;
}
