package com.pets.virtualpetshop.service;

import com.pets.virtualpetshop.model.BankAccount;
import com.pets.virtualpetshop.repository.BankAccountRepository;
import org.springframework.stereotype.Service;

@Service
public class BankAccountService {

    private final BankAccountRepository bankAccountRepository;

    public BankAccountService(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    public BankAccount getByCardNumber(String cardNumber){
        return bankAccountRepository.findBankAccountByCardNumber(cardNumber);
    }

    public BankAccount save(BankAccount bankAccount){
        return bankAccountRepository.save(bankAccount);
    }

}
