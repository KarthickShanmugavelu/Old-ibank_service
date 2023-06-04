package com.ibank.service.controller;

import com.ibank.service.dao.dto.AccountHolderDto;
import com.ibank.service.service.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ibank")
public class TransactionsController {

    @Autowired
    TransactionsService service;

    @GetMapping("/addAccount")
    public ResponseEntity<String> addCustomer(@RequestBody List<AccountHolderDto> accountHolderDtoList){
            String insertionStatus= service.insertAccountHolder(accountHolderDtoList);
            return new ResponseEntity<>(insertionStatus, HttpStatus.OK);
    }
}
