package kaua.recisao.dto.request.EmployeeTermination;

import java.time.LocalDate;

public record EmployeeTerminationUpdateRequest(
        String nameEmployee,
        String nameStore,
        LocalDate dateTermination,
        Boolean vt,
        Boolean vr,
        Boolean sac,
        Boolean healthPlan,
        Long version

) {
}
