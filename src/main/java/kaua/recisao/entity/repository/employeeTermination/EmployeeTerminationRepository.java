package kaua.recisao.entity.repository.employeeTermination;

import kaua.recisao.entity.model.EmployeeTermination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeTerminationRepository extends JpaRepository<EmployeeTermination, Integer> {



}
