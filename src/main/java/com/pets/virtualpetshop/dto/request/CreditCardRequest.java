package com.pets.virtualpetshop.dto.request;

import com.pets.virtualpetshop.model.BaseEntity;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class CreditCardRequest extends BaseEntity {

    private String cardNumber;
    private String nameAndLastname;
    private int cvv;
    private String expirationDate;

    public CreditCardRequest(String cardNumber, String nameAndLastname, int cvv, String expirationDate) {
        this.cardNumber = cardNumber;
        this.nameAndLastname = nameAndLastname;
        this.cvv = cvv;
        this.expirationDate = expirationDate;
    }

}
