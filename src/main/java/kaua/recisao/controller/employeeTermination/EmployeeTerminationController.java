package kaua.recisao.controller.employeeTermination;


import kaua.recisao.dto.request.EmployeeTermination.EmployeeTerminationRequest;
import kaua.recisao.dto.response.EmployeeTermination.EmployeeTerminationResponse;
import kaua.recisao.service.EmployeeTermination.EmployeeTerminationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class EmployeeTerminationController {


    private final EmployeeTerminationService employeeTerminationService;

    public EmployeeTerminationController(EmployeeTerminationService employeeTerminationService) {
        this.employeeTerminationService = employeeTerminationService;
    }



    @PostMapping("employeeTermination")
    public EmployeeTerminationResponse createEmployee(@RequestBody EmployeeTerminationRequest request){
        return employeeTerminationService.createEmployeeTermination(request);
    }





}
