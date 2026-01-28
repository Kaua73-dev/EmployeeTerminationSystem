package kaua.recisao.auth;


import kaua.recisao.entity.repository.user.UserRepository;
import kaua.recisao.exceptions.user.UserNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthUserService implements UserDetailsService {

    private final UserRepository userRepository;

    public AuthUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String cpf) throws UsernameNotFoundException {
        return userRepository.findByCpf(cpf).orElseThrow(() -> new UserNotFoundException());
    }
}
