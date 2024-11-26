package com.easybytes.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardsController {

    @GetMapping("/myCards")
    public String getCardsDetails() {
        return "Your Credit Card Details are: Card Number: 1234 5678 9012 3456, Card Type: VISA, Card Limit: $5000.00, Card Balance: $2000.00";
    }
}
