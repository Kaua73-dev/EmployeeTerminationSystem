package kaua.recisao.exceptions.user;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class UserNotAdminException extends RuntimeException {
    public UserNotAdminException() {
        super("User not admin");
    }
}
