package co.pragra.learning.employedemo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data

@Table(name = "table_employee_address")
public class EmployeeAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;
    private String street;
    private String city;
    private String province;
    private String country;
    private String postalCode;
    private String unit;

}
