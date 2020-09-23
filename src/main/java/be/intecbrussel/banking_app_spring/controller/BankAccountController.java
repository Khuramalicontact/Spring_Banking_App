package be.intecbrussel.banking_app_spring.controller;

import be.intecbrussel.banking_app_spring.model.BankAccount;
import be.intecbrussel.banking_app_spring.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BankAccountController {

    BankAccountService bankAccountService;

    @Autowired
    public BankAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @GetMapping("/bankaccounts")
    public List<BankAccount> getAllBankAccounts() {
        return bankAccountService.getAllBankAccounts();
    }

    @PostMapping(value = "/bankaccounts/add", consumes = "application/json")
    public void addBankAccount(@RequestBody BankAccount bankAccount) {
        System.out.println("saving bankaccount");
        bankAccountService.saveBankAccount(bankAccount);
    }

    @PostMapping(value = "/bankaccount/{clientId}")
    public void createBankAccount(@PathVariable int clientId){
        bankAccountService.createBankAccount(clientId);
    }

}
