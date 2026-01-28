package kaua.recisao.entity.model;


import jakarta.persistence.*;
import kaua.recisao.entity.enums.EmployeeTerminationEnum;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name="employee_termination")
public class EmployeeTermination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="name_employee", nullable = false, length = 1000)
    private String nameEmployee;

    @Column(name="name_store", nullable = false, length = 1000)
    private String nameStore;

    @Column(name="date_termination", nullable = false)
    private LocalDate dateTermination;

    private Boolean vt;

    private Boolean vr;

    private Boolean sac;

    @Column(name="health_plan")
    private Boolean healthPlan;

    @Enumerated(EnumType.STRING)
    private EmployeeTerminationEnum employeeTerminationEnum;

    @Version
    private Long version;

    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private User user;


}
