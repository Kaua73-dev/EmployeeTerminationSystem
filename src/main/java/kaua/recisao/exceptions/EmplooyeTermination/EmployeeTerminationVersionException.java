package kaua.recisao.exceptions.EmplooyeTermination;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeTerminationVersionException extends RuntimeException {
    public EmployeeTerminationVersionException() {
        super("Employee termination version is not null");
    }
}
