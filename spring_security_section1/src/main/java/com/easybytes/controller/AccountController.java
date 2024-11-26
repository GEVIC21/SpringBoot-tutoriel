package com.easybytes.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @GetMapping("/myAccount")
    public String getAccountDetails() {
        return "Account Details: Savings Account, Account Number: 1234567890, Branch: Bangalore";
    }
}
