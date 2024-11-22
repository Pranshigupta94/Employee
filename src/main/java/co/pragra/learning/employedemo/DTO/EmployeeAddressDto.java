package co.pragra.learning.employedemo.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeAddressDto {
    private long id;

    @NotBlank(message = "Street is mandatory")
    private String street;

    @NotBlank(message = "City is mandatory")
    private String city;

    @NotBlank(message = "Province is mandatory")
    private String province;

    @NotBlank(message = "Country is mandatory")
    private String country;

    @NotBlank(message = "Postal Code is mandatory")

    private String postalCode;

    private String unit;

}
