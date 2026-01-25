package kaua.recisao.dto.request.user;

public record UserUpdateRequest(String name, String cpf, String password, String provider) {
}
