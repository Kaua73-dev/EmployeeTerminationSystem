package kaua.recisao.service.user;


import kaua.recisao.auth.AuthVerifyService;
import kaua.recisao.config.TokenConfig;
import kaua.recisao.dto.request.user.UserLoginRequest;
import kaua.recisao.dto.request.user.UserRegisterRequest;
import kaua.recisao.dto.request.user.UserUpdateRequest;
import kaua.recisao.dto.response.user.UserLoginResponse;
import kaua.recisao.dto.response.user.UserResponse;
import kaua.recisao.entity.enums.UserEnum;
import kaua.recisao.entity.model.User;
import kaua.recisao.entity.repository.UserRepository;
import kaua.recisao.exceptions.user.UserAlreadyExistException;
import kaua.recisao.exceptions.user.UserNotAdminException;
import kaua.recisao.exceptions.user.UserNotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService extends AuthVerifyService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final TokenConfig tokenConfig;

    private UserResponse toResponse(User u){
        return new UserResponse(
            u.getName(),
            u.getCpf(),
            u.getProvider()
        );
    }


    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, TokenConfig tokenConfig) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.tokenConfig = tokenConfig;
    }

    public UserResponse register(UserRegisterRequest request){
        if(userRepository.findByCpf(request.cpf()).isPresent()){
            throw new UserAlreadyExistException();
        }

        User user = new User();
        user.setName(request.name());
        user.setCpf(request.cpf());
        user.setPassword(passwordEncoder.encode(request.password()));
        user.setProvider(request.provider());
        user.setUserEnum(UserEnum.USER);

        User userSaved = userRepository.save(user);

        return new UserResponse(
                userSaved.getName(),
                userSaved.getCpf(),
                userSaved.getProvider()
        );

    }

    public UserLoginResponse login(UserLoginRequest request){
        if(userRepository.findByCpf(request.cpf()).isEmpty()){
            throw new UserNotFoundException();
        }

        UsernamePasswordAuthenticationToken  userAndPass = new UsernamePasswordAuthenticationToken(request.cpf(), request.password());
        Authentication authentication = authenticationManager.authenticate(userAndPass);

        User user = (User) authentication.getPrincipal();
        String token = tokenConfig.generateToken(user);
        return new UserLoginResponse(token);


    }


    public List<UserResponse> getAllUsers(){
        User user = getAuthenticate();

       if(!user.getUserEnum().equals(UserEnum.ADMIN)){
           throw new UserNotAdminException();
       }

       return userRepository.findAll()
                .stream()
                .map(this::toResponse).toList();
    }

    @Transactional
    public void deleteUserByCpf(String cpf){
        User user = getAuthenticate();

        if(!user.getUserEnum().equals(UserEnum.ADMIN)){
            throw new UserNotAdminException();
        }

        userRepository.deleteUserByCpf(cpf);

    }


    public UserResponse updateUserByCpf(String cpf, UserUpdateRequest request){

        User user = userRepository.findByCpf(cpf).orElseThrow(() ->
                new UserNotAdminException()
                );

         if(userRepository.findByCpf(cpf).isEmpty()){
             throw new UserNotFoundException();
         }

         if(user.getName() != null){
             user.setName(request.name());
         }

         if(user.getCpf() != null){
             user.setCpf(request.cpf());
         }

         if(user.getPassword() != null){
             user.setPassword(passwordEncoder.encode(request.password()));
         }

         if(user.getProvider() != null){
             user.setProvider(request.provider());
         }


         return toResponse(userRepository.save(user));
    }


}
