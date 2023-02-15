package com.pets.virtualpetshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class VirtualPetShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(VirtualPetShopApplication.class, args);
	}
}
//TODO : pagination -> task 1
//TODO : buy advert -> seneryo 1: satin alimlar db de tutulur seneryo 2: satin alindiktan sonra bilgilendirme maili gonderilir
//TODO: seneryo 3: iade seneryosu yazilir -> ilk once surec baslatilir sonrasinda iade onayi beklenir -> iade onaylanir ise bakiye
//TODO: iade edilir
//TODO: satin alim ek gelistirme : kullaniciya taksitle odeme imkani da sunulur
// TODO: userDto -> isActivate eklecek