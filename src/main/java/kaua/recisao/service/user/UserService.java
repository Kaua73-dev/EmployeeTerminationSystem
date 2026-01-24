package kaua.recisao.service.user;


import kaua.recisao.dto.request.user.UserRegisterRequest;
import kaua.recisao.dto.response.user.UserRegisterResponse;
import kaua.recisao.entity.repository.UserRepository;
import kaua.recisao.exceptions.user.UserAlreadyExistException;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserRegisterResponse register(UserRegisterRequest request, String cpf){
        if(userRepository.findByCpf(cpf).isPresent()){
            throw new UserAlreadyExistException();
        }


    }

}
