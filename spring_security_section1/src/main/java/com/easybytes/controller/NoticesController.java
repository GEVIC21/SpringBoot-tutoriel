package com.easybytes.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticesController {

    @GetMapping("/notices")
    public String getNotices() {
        return "Notices: 1. Your Account will be debited with $1000 on 1st of every month. 2. Please maintain minimum balance of $1000 in your account. 3. Please ignore if you have already paid the bill.";
    }
}
