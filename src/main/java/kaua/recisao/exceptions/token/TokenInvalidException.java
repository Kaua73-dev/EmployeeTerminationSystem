package kaua.recisao.exceptions.token;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class TokenInvalidException extends RuntimeException {
    public TokenInvalidException() {
        super("Token invalid");
    }
}
