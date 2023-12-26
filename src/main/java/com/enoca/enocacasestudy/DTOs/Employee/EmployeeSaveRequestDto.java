package com.enoca.enocacasestudy.DTOs.Employee;

import jakarta.validation.constraints.*;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.enoca.enocacasestudy.Entity.Employee}
 */
@Value
public class EmployeeSaveRequestDto implements Serializable {
    @NotNull(message = "CompanyId can not be null")
    @Positive(message = "CompanyId can not be negative")
    Long CompanyId;
    @NotNull(message = "name can not be null")
    @NotEmpty(message = "name can not be empty")
    @NotBlank(message = "name can not be blank")
    String name;
    @NotNull(message = "surname can not be null")
    @NotEmpty(message = "surname can not be null")
    @NotBlank(message = "surname can not be null")
    String surname;
    @Positive(message = "salary can not be negative or zero")
    double salary;
    @Positive(message = "salary can not be negative or zero")
    Integer age;
    @Email(message = "must be a valid email.")
    String email;
}