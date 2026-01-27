package kaua.recisao.service.EmployeeTermination;


import kaua.recisao.auth.AuthVerifyService;
import kaua.recisao.entity.repository.EmployeeTerminationRepository;
import kaua.recisao.entity.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeTerminationService extends AuthVerifyService {

    private final EmployeeTerminationRepository employeeTerminationRepository;

    public EmployeeTerminationService(EmployeeTerminationRepository employeeTerminationRepository) {
        this.employeeTerminationRepository = employeeTerminationRepository;
    }








}
