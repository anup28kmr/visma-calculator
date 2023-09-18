package com.visma.calculator.controller;

import com.visma.calculator.dto.LoanDto;
import com.visma.calculator.service.LoanCalculatorService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/loan")
@AllArgsConstructor
public class LoanCalculatorController {

    @GetMapping
    public String showLoanCalculator(LoanDto loan) {
        return "loanCalculator";
    }

    private LoanCalculatorService loanCalculatorService;

    @PostMapping
    public String calculateLoan(@Valid LoanDto loan, BindingResult result, Model model) {
        if(result.hasErrors()){
            return "loanCalculator";
        }
        model.addAttribute("loanResult",loanCalculatorService.calculateLoan(loan));
        return "loanCalculator";
    }
}
