package kaua.recisao.controller.employeeTermination;


import kaua.recisao.dto.request.EmployeeTermination.EmployeeTerminationRequest;
import kaua.recisao.dto.request.EmployeeTermination.EmployeeTerminationUpdateRequest;
import kaua.recisao.dto.response.EmployeeTermination.EmployeeTerminationResponse;
import kaua.recisao.service.EmployeeTermination.EmployeeTerminationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class EmployeeTerminationController {


    private final EmployeeTerminationService employeeTerminationService;

    public EmployeeTerminationController(EmployeeTerminationService employeeTerminationService) {
        this.employeeTerminationService = employeeTerminationService;
    }



    @PostMapping("/employeeTermination")
    public EmployeeTerminationResponse createEmployee(@RequestBody EmployeeTerminationRequest request){
        return employeeTerminationService.createEmployeeTermination(request);
    }


    @GetMapping("/employeeTermination")
    public List<EmployeeTerminationResponse> findAllEmployeeTermination(){
        return employeeTerminationService.findAllEmployeeTermination();
    }


    @PutMapping("/employeeTermination/{nameEmployee}")
    public EmployeeTerminationResponse updateEmployeeTerminationByName(EmployeeTerminationUpdateRequest request){
        return employeeTerminationService.updateEmployeeTerminationByName(request);
    }




}
