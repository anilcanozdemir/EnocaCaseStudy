package com.enoca.enocacasestudy.DTOs.Company;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.enoca.enocacasestudy.Entity.Company}
 */
@Value
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class CompanySaveRequestDto implements Serializable {
    @NotNull(message = "companyName must be not null")
    @NotEmpty(message = "companyName must be not empty")
    @NotBlank(message = "companyName must be not blank")
    String companyName;
}