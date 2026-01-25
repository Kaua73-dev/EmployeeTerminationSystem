package kaua.recisao.auth;


import kaua.recisao.entity.model.User;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Objects;

public abstract class AuthVerifyService {

    protected User getAuthenticate(){
        return (User) Objects.requireNonNull(SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal()

        );
    }


}
