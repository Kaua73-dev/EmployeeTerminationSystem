package kaua.recisao.dto.request.EmployeeTermination;


import kaua.recisao.entity.enums.EmployeeTerminationEnum;

import java.time.LocalDate;

public record EmployeeTerminationRequest(
    String nameEmployee,
    String nameStore,
    LocalDate dateTermination,
    Boolean vt,
    Boolean vr,
    Boolean sac,
    Boolean healthPlan,
    EmployeeTerminationEnum employeeTerminationEnum

) {
}
