package kaua.recisao.service.EmployeeTermination;


import kaua.recisao.auth.AuthVerifyService;
import kaua.recisao.dto.request.EmployeeTermination.EmployeeTerminationRequest;
import kaua.recisao.dto.response.EmployeeTermination.EmployeeTerminationResponse;
import kaua.recisao.entity.model.User;
import kaua.recisao.entity.repository.employeeTermination.EmployeeTerminationRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeTerminationService extends AuthVerifyService {

    private final EmployeeTerminationRepository employeeTerminationRepository;

    public EmployeeTerminationService(EmployeeTerminationRepository employeeTerminationRepository) {
        this.employeeTerminationRepository = employeeTerminationRepository;
    }




    public EmployeeTerminationResponse createEmployeeTermination(EmployeeTerminationRequest request){
        User user = getAuthenticate();

        if(employeeTerminationRepository.)




    }





}
