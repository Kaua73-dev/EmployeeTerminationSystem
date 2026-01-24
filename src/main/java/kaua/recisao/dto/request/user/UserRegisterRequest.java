package kaua.recisao.dto.request.user;

public record UserRegisterRequest(String name, String cpf, String password, String provider) {
}
