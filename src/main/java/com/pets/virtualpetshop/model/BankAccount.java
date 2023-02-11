package com.pets.virtualpetshop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String CardNumber;
    private String nameAndLastname;
    private int cvv;
    private String expirationDate;
    private double balance;

    public BankAccount(String cardNumber, String nameAndLastname, int cvv, String expirationDate,double balance) {
        CardNumber = cardNumber;
        this.nameAndLastname = nameAndLastname;
        this.cvv = cvv;
        this.expirationDate = expirationDate;
        this.balance = balance;
    }
}
