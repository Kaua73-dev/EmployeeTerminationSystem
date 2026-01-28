package kaua.recisao.exceptions.EmplooyeTermination;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class EmployeeTerminationAlreadyExistException extends RuntimeException {
    public EmployeeTerminationAlreadyExistException() {
        super("Employee termination already exist");
    }
}
