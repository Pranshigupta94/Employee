package co.pragra.learning.employedemo.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data

@Table(name = "table_employee")
public class EmployeeEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)

        private long id;
        private String employeeName;
        private String phoneNumber;
        private String email;

        @OneToOne(cascade = CascadeType.ALL) // cascade-ensures the EmployeeAddress is saved or deleted alongside the EmployeeEntity.
        @JoinColumn(name = "address_id", referencedColumnName = "id") //indicates the foreign key in the table_employee table.

        private EmployeeAddress address;

}


