package kaua.recisao.dto.response.EmployeeTermination;

import kaua.recisao.entity.enums.EmployeeTerminationEnum;

import java.time.LocalDate;

public record EmployeeTerminationResponse(
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
