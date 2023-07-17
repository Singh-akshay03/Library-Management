package com.librarymanagement.controllers;

import com.librarymanagement.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @PostMapping("/transaction/issue")
    public void issueTx(){
        transactionService.issueTxn();
    }
}
