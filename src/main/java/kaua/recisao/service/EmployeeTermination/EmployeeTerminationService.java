package kaua.recisao.service.EmployeeTermination;


import kaua.recisao.auth.AuthVerifyService;
import kaua.recisao.dto.request.EmployeeTermination.EmployeeTerminationRequest;
import kaua.recisao.dto.response.EmployeeTermination.EmployeeTerminationResponse;
import kaua.recisao.entity.enums.EmployeeTerminationEnum;
import kaua.recisao.entity.model.EmployeeTermination;
import kaua.recisao.entity.model.User;
import kaua.recisao.entity.repository.employeeTermination.EmployeeTerminationRepository;
import kaua.recisao.entity.repository.user.UserRepository;
import kaua.recisao.exceptions.EmplooyeTermination.EmployeeTerminationAlreadyExistException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeTerminationService extends AuthVerifyService {

    private final EmployeeTerminationRepository employeeTerminationRepository;
    private final UserRepository userRepository;

    public EmployeeTerminationService(EmployeeTerminationRepository employeeTerminationRepository, UserRepository userRepository) {
        this.employeeTerminationRepository = employeeTerminationRepository;
        this.userRepository = userRepository;
    }

    private EmployeeTerminationResponse toResponse(EmployeeTermination e){
        return new EmployeeTerminationResponse(
                e.getNameEmployee(),
                e.getNameStore(),
                e.getDateTermination(),
                e.getVt(),
                e.getVr(),
                e.getSac(),
                e.getHealthPlan(),
                e.getEmployeeTerminationEnum(),
                e.getVersion(),
                e.getUser().getId()
        );
    }




    public EmployeeTerminationResponse createEmployeeTermination(EmployeeTerminationRequest request){
        User user = getAuthenticate();

        if(employeeTerminationRepository.findByNameEmployeeAndUser(request.nameEmployee(), user).isPresent()){
            throw new EmployeeTerminationAlreadyExistException();
        }


        EmployeeTermination termination = new EmployeeTermination();
        termination.setNameEmployee(request.nameEmployee());
        termination.setNameStore(request.nameStore());
        termination.setDateTermination(request.dateTermination());
        termination.setVt(request.vt());
        termination.setVr(request.vr());
        termination.setSac(request.sac());
        termination.setHealthPlan(request.healthPlan());
        termination.setEmployeeTerminationEnum(EmployeeTerminationEnum.UNSIGNED);
        termination.setUser(user);

        EmployeeTermination employeeSaved = employeeTerminationRepository.save(termination);


        return toResponse(employeeTerminationRepository.save(termination));

    }


        public List<EmployeeTerminationResponse> findAllEmployeeTermination(){

            User user = getAuthenticate();

            return employeeTerminationRepository.findAll()
                    .stream()
                    .map(this::toResponse).toList();

        }


        public EmployeeTerminationResponse updateEmployeeTerminationByName(EmployeeTerminationRequest request){
            User user = getAuthenticate();

            EmployeeTermination termination = employeeTerminationRepository.findByNameEmployeeAndUser(request.nameEmployee(), user).orElseThrow(() ->

                        new EmployeeTermination

                    );


            if()






        }




}
