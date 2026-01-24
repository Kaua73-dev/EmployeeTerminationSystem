package kaua.recisao.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import kaua.recisao.entity.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TokenConfig {

    @Value("{jwt.secret}")
    private String secret;



    public String generateToken(User user){

        Algorithm algorithm = Algorithm.HMAC256(secret);

        try {
            String token = JWT.create()
                    .withClaim("UserName ", user.getUsername())
                    .withSubject(user.get)
        }

    }




}
