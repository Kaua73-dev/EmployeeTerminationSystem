package kaua.recisao.service.EmployeeTermination;


import kaua.recisao.auth.AuthVerifyService;
import kaua.recisao.dto.request.EmployeeTermination.EmployeeTerminationRequest;
import kaua.recisao.dto.response.EmployeeTermination.EmployeeTerminationResponse;
import kaua.recisao.entity.model.EmployeeTermination;
import kaua.recisao.entity.model.User;
import kaua.recisao.entity.repository.employeeTermination.EmployeeTerminationRepository;
import kaua.recisao.entity.repository.user.UserRepository;
import kaua.recisao.exceptions.EmplooyeTermination.EmployeeTerminationAlreadyExistException;
import kaua.recisao.exceptions.user.UserNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class EmployeeTerminationService extends AuthVerifyService {

    private final EmployeeTerminationRepository employeeTerminationRepository;
    private final UserRepository userRepository;


    public EmployeeTerminationService(EmployeeTerminationRepository employeeTerminationRepository, UserRepository userRepository) {
        this.employeeTerminationRepository = employeeTerminationRepository;
        this.userRepository = userRepository;
    }




    public EmployeeTerminationResponse createEmployeeTermination(EmployeeTerminationRequest request){
        User user = getAuthenticate();

        if(!user.getCpf().equals(user.getCpf())){
            throw new UserNotFoundException();
        }

        if(employeeTerminationRepository.findByNameEmployee(request.nameEmployee()).isEmpty()){
            throw new EmployeeTerminationAlreadyExistException();
        }


        EmployeeTermination termination = new EmployeeTermination();
        termination.setName_employee(request.nameEmployee());
        termination.setName_store(request.nameStore());
        termination.setDate_termination(request.dateTermination());
        termination.setVt(request.vt());
        termination.setVr(request.vr());
        termination.setSac(request.sac());
        termination.setHealth_plan(request.healthPlan());
        termination.setEmployeeTerminationEnum(request.employeeTerminationEnum());
        termination.setUser(user);

        employeeTerminationRepository.save(termination);

        return new EmployeeTerminationResponse(




        );



    }





}
