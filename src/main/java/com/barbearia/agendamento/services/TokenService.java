package com.barbearia.agendamento.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.barbearia.agendamento.model.User;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    public String gerarToken(User user) {
        try {
            var algoritmo = Algorithm.HMAC256("123456");
            return JWT.create()
                    .withIssuer("API agendamento barber")
                    .withSubject(user.getUsername())
                    .sign(algoritmo);
        } catch (JWTCreationException exception){
            throw new RuntimeException("error ao gerar token jwt", exception);
        }
    }
}
