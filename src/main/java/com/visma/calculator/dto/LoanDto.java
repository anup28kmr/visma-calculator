package com.visma.calculator.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoanDto {

    @NotNull(message = "Loan amount must not be null")
    @Positive(message = "Loan amount must be positive")
    private Double loanAmount;

    private Double monthlyPayment;

    private Double totalPayment;

    @NotNull(message = "Payback years must not be null")
    @Min(value = 1, message = "Payback years must be at least 1")
    @Max(value = 30, message = "Payback years cannot exceed 30")
    private Integer paybackYears;

    public LoanDto(@NonNull Double monthlyPayment, Double totalPayment, @NonNull Integer paybackYears) {
        this.monthlyPayment = monthlyPayment;
        this.totalPayment = totalPayment;
        this.paybackYears = paybackYears;
    }
}
