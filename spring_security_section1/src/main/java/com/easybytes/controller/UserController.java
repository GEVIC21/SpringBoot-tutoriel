package com.easybytes.controller;


import com.easybytes.model.Customer;
import com.easybytes.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;


    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Customer customer) {
        try {
            String hashedPassword = passwordEncoder.encode(customer.getPwd());
            customer.setPwd(hashedPassword);
            Customer savedCustomer = customerRepository.save(customer);
            if(savedCustomer.getId()>0){
                return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
            }else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).
                        body("User registration failed. Please try again later.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body("An exception occurred while registering the user. Please try again later." + e.getMessage());
        }

    }

}