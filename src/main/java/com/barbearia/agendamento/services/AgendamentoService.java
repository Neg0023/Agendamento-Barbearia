package com.barbearia.agendamento.services;

import com.barbearia.agendamento.Exception.ClienteNaoExiste;
import com.barbearia.agendamento.Exception.HorarioExiste;
import com.barbearia.agendamento.dto.AgendamentoModel;
import com.barbearia.agendamento.model.Agendamento;
import com.barbearia.agendamento.repository.AgendamentoRepository;
import com.barbearia.agendamento.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public Agendamento agendamento(AgendamentoModel agendamento){
        var customer = customerRepository.findByCpf(agendamento.getCpf()).orElseThrow(() -> new ClienteNaoExiste("Cliente não existe"));

        SimpleDateFormat formatoEntrada = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        SimpleDateFormat formatoSaida = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        String dataFormatada = null;
        try {
            Date data = formatoEntrada.parse(agendamento.getHorario());
            dataFormatada = formatoSaida.format(data);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if(agendamentoRepository.existsByHorario(dataFormatada)){
            log.error("Horario já reservado");
            throw new HorarioExiste("Horario já reservado");
        }

        var buildAgendamento = Agendamento.builder()
                .cpf(agendamento.getCpf())
                .nome(customer.getName().concat(" " + customer.getSobreNome()))
                .horario(dataFormatada)
                .formaPagamento(agendamento.getFormaPagamento())
                .statusPagamento(agendamento.getStatusPagamento())
                .build();
        return agendamentoRepository.save(buildAgendamento);
    }

    public List<Agendamento> getAgendamento(){
        var list = agendamentoRepository.findAll();
        return list;
    }
}
