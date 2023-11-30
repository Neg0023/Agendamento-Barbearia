package com.barbearia.agendamento.controller;

import com.barbearia.agendamento.dto.AgendamentoModel;
import com.barbearia.agendamento.model.Agendamento;
import com.barbearia.agendamento.services.AgendamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendamento")
public class AgentementoController {

    @Autowired
    private AgendamentoService agendamentoService;

    @PostMapping
    public ResponseEntity<Agendamento> agendamento(@RequestBody @Valid AgendamentoModel agendamento){
        return ResponseEntity.ok().body(agendamentoService.agendamento(agendamento));
    }

    @GetMapping
    public ResponseEntity<List<Agendamento>> getAgendamento(){
        var listAgendamento = agendamentoService.getAgendamento();
        return ResponseEntity.ok().body(listAgendamento);
    }
}
