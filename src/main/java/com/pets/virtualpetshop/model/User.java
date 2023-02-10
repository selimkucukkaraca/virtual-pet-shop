package com.pets.virtualpetshop.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
    private String mail;
    private String imageUrl;
    private boolean isActive = false;
    @OneToOne
    private ConfirmCode confirmCode;
    private UserType userType;

    public User(String username, String password, String mail, String imageUrl) {
        this.username = username;
        this.password = password;
        this.mail = mail;
        this.imageUrl = imageUrl;
    }
}
