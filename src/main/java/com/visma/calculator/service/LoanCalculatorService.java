package com.visma.calculator.service;

import com.visma.calculator.dto.LoanDto;

public interface LoanCalculatorService {
    LoanDto calculateLoan(LoanDto loan);
}
