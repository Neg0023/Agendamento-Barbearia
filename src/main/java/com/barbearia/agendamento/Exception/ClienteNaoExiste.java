package com.barbearia.agendamento.Exception;

public class ClienteNaoExiste extends RuntimeException{

    public ClienteNaoExiste(String message) {
        super(message);
    }
}
