package com.ibank.service.controller;

import com.ibank.service.service.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/transaction")
public class TransactionsController {

    @Autowired
    TransactionsService service;

    @GetMapping("/getTransactionSummary/{id}")
    public ResponseEntity<List<Map<String,Object>>> getTransactionSummary(@PathVariable("id") int id){
        List<Map<String,Object>> transactionSummary = service.getTransactionSummary(id);
        return new ResponseEntity<>(transactionSummary, HttpStatus.OK);
    }

    @PostMapping("/deposit")
    public ResponseEntity<String> deposit(@RequestParam("accountId") int accountId,@RequestParam("amount")int amount){
        String depositStatus = service.deposit(accountId,amount);
        return new ResponseEntity<>(depositStatus,HttpStatus.OK);
    }
}
