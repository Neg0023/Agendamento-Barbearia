package com.barbearia.agendamento.services;

import com.barbearia.agendamento.Exception.ClienteNaoExiste;
import com.barbearia.agendamento.Exception.HorarioExiste;
import com.barbearia.agendamento.dto.AgendamentoModel;
import com.barbearia.agendamento.model.Agendamento;
import com.barbearia.agendamento.repository.AgendamentoRepository;
import com.barbearia.agendamento.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public Agendamento agendamento(AgendamentoModel agendamento){
        customerRepository.findByCpf(agendamento.getCpf()).orElseThrow(() -> new ClienteNaoExiste("Cliente não existe"));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        var data = LocalDateTime.parse(agendamento.getHorario(), formatter).toString();

        if(agendamentoRepository.existsByHorario(data)){
            throw new HorarioExiste("Horario já reservado");
        }

        var buildAgendamento = Agendamento.builder()
                .cpf(agendamento.getCpf())
                .horario(data)
                .formaPagamento(agendamento.getFormaPagamento())
                .statusPagamento(agendamento.getStatusPagamento())
                .build();
        return agendamentoRepository.save(buildAgendamento);
    }

    public List<Agendamento> getAgendamento(){
        var list = agendamentoRepository.findAll();
        list.stream().forEach(item ->{
            SimpleDateFormat formatoEntrada = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
            SimpleDateFormat formatoSaida = new SimpleDateFormat("dd/MM/yyyy HH:mm");

            Date dataObj = null;
            try {
                dataObj = formatoEntrada.parse(item.getHorario());
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            String dataFormatada = formatoSaida.format(dataObj);
            item.setHorario(dataFormatada);
        });
        return list;
    }
}
