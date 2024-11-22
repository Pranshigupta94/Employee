package co.pragra.learning.employedemo.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@NoArgsConstructor
public class EmployeeDTO {

    private long id;

    @NotBlank(message = "Employee name should not be empty")
    private String employeeName;

    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Phone number should not be empty")
    private String phoneNumber;

    private EmployeeAddressDto address;



   /* // parameterised Constructor to initialize EmployeeDTO
    public EmployeeDTO(long id, String employeeName, String email, String phoneNumber) {
        this.id = id;
        this.employeeName = employeeName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }*/
}