package kaua.recisao.exceptions.EmplooyeTermination;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeTerminationNotFoundException extends RuntimeException {
    public EmployeeTerminationNotFoundException() {
        super("Employee Termination not found");
    }
}
