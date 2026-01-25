package kaua.recisao.controller;


import kaua.recisao.dto.request.user.UserLoginRequest;
import kaua.recisao.dto.request.user.UserRegisterRequest;
import kaua.recisao.dto.response.user.UserLoginResponse;
import kaua.recisao.dto.response.user.UserResponse;
import kaua.recisao.service.user.UserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/register")
    public UserResponse register(@RequestBody UserRegisterRequest request){
        return userService.register(request);
    }


    @PostMapping("/login")
    public UserLoginResponse login(@Validated @RequestBody UserLoginRequest request){
        return userService.login(request);
    }

    @GetMapping("/admin/users")
    public List<UserResponse> getAllUsers(){
        return userService.getAllUsers();
    }


    @DeleteMapping("/admin/users/{cpf}")
    public void deleteUserByCpf(@PathVariable String cpf){
         userService.deleteUserByCpf(cpf);
    }


}
