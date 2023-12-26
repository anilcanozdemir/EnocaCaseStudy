package com.enoca.enocacasestudy.DTOs.Company;

import com.enoca.enocacasestudy.Entity.Employee;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Value;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link com.enoca.enocacasestudy.Entity.Company}
 */
@Value
public class CompanyDto implements Serializable {
    @NotNull(message = "id can not be null")
    @Positive(message = "id can not be negative")
    Long id;
    @NotNull(message = "companyName must be not null")
    @NotEmpty(message = "companyName must be not empty")
    @NotBlank(message = "companyName must be not blank")
    String companyName;
}