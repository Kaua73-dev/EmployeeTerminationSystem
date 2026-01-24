package kaua.recisao.service.user;


import kaua.recisao.dto.request.user.UserRegisterRequest;
import kaua.recisao.dto.response.user.UserRegisterResponse;
import kaua.recisao.entity.model.User;
import kaua.recisao.entity.repository.UserRepository;
import kaua.recisao.exceptions.user.UserAlreadyExistException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserRegisterResponse register(UserRegisterRequest request, String cpf){
        if(userRepository.findByCpf(cpf).isPresent()){
            throw new UserAlreadyExistException();
        }

        User user = new User();
        user.setName(request.name());
        user.setCpf(request.cpf());
        user.setPassword(passwordEncoder.encode(request.password()));
        user.setProvider(request.provider());

        return new UserRegisterResponse(
          user.getName(),
          user.getCpf(),
          user.getProvider()
        );

    }

}
