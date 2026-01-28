package kaua.recisao.entity.repository.employeeTermination;

import kaua.recisao.entity.model.EmployeeTermination;
import kaua.recisao.entity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeTerminationRepository extends JpaRepository<EmployeeTermination, Integer> {

    Optional<EmployeeTermination> findByNameEmployeeAndUser(String nameEmployee, User user);

}
