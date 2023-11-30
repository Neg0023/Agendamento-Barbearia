package com.barbearia.agendamento.Exception;

public class HorarioExiste extends RuntimeException{

    public HorarioExiste(String message) {
        super(message);
    }
}
