package kaua.recisao.dto.request.EmployeeTermination;


import kaua.recisao.entity.enums.EmployeeTerminationEnum;

import java.time.LocalDate;

public record EmployeeTerminationRequest(
    String name_employee,
    String name_store,
    LocalDate date_termination,
    Boolean vt,
    Boolean vr,
    Boolean sac,
    Boolean health_plan,
    EmployeeTerminationEnum employeeTerminationEnum

) {
}
