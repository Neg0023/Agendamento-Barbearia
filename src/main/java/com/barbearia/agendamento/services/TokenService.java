package com.barbearia.agendamento.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.barbearia.agendamento.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    @Value(value = "${api.security.token.secret}")
    private String secret;

    public String gerarToken(User user) {

        try {
            var algoritmo = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("API agendamento barber")
                    .withSubject(user.getUsername())
                    .withClaim("password", user.getPassword())
                    .sign(algoritmo);
        } catch (JWTCreationException exception){
            throw new RuntimeException("error ao gerar token jwt", exception);
        }
    }
}
