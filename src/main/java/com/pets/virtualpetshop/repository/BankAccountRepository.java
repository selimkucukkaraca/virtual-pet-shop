package com.pets.virtualpetshop.repository;

import com.pets.virtualpetshop.model.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount,Long> {

    BankAccount findBankAccountByCardNumber(String cardNumber);

}
