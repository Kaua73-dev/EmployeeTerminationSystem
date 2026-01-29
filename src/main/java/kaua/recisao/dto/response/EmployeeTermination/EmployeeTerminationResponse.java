package kaua.recisao.dto.response.EmployeeTermination;

import kaua.recisao.entity.enums.EmployeeTerminationEnum;
import kaua.recisao.entity.model.User;

import java.time.LocalDate;

public record EmployeeTerminationResponse(
        String nameEmployee,
        String nameStore,
        LocalDate dateTermination,
        Boolean vt,
        Boolean vr,
        Boolean sac,
        Boolean healthPlan,
        EmployeeTerminationEnum employeeTerminationEnum,
        Long version,
        Integer user,
        Long version
) {
}
