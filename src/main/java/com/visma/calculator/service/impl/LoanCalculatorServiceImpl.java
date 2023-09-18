package com.visma.calculator.service.impl;

import com.visma.calculator.dto.LoanDto;
import com.visma.calculator.service.LoanCalculatorService;
import org.springframework.stereotype.Service;

@Service
public class LoanCalculatorServiceImpl implements LoanCalculatorService {
    @Override
    public LoanDto calculateLoan(LoanDto loan) {
        double annualInterestRate = 0.06; // 3.5% annual interest rate
        int months = loan.getPaybackYears() * 12;
        double monthlyInterestRate = annualInterestRate / 12;

        double monthlyPayment = (loan.getLoanAmount() * monthlyInterestRate) /
                (1 - Math.pow(1 + monthlyInterestRate, -months));

        double totalPayment = monthlyPayment * months;

        return new LoanDto(monthlyPayment, totalPayment, loan.getPaybackYears());
    }
}
