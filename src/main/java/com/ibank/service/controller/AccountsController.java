package com.ibank.service.controller;

import com.ibank.service.dao.dto.AccountHolderDto;
import com.ibank.service.service.AccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/ibank")
public class AccountsController {

    @Autowired
    AccountsService service;

    @GetMapping("/getAccounts")
    public ResponseEntity<List<Map<String, Object>>> getAccounts(){
        List<Map<String, Object>> accountList=service.getAccounts();
        return new ResponseEntity<>(accountList,HttpStatus.OK);
    }

    @GetMapping("/getAccount/{id}")
    public ResponseEntity<Map<String, Object>> getAccountById(@PathVariable("id") int id){
        Map<String, Object> account=service.getAccountById(id);
        return new ResponseEntity<>(account,HttpStatus.OK);
    }

    @PutMapping("/updateAccount/{id}")
    public ResponseEntity<String> updateCustomer(@PathVariable("id") int id, @RequestBody AccountHolderDto accountHolderDto){
        String updateStatus= service.updateCustomer(id,accountHolderDto);
        return new ResponseEntity<>(updateStatus, HttpStatus.OK);
    }

    @DeleteMapping("/deleteAccount/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable("id") int id) {
        return new ResponseEntity<>(service.deleteAccountById(id), HttpStatus.OK);
    }
    @PostMapping("/addAccount")
    public ResponseEntity<String> addCustomer(@RequestBody List<AccountHolderDto> accountHolderDtoList){
            String insertionStatus= service.insertAccountHolder(accountHolderDtoList);
            return new ResponseEntity<>(insertionStatus, HttpStatus.OK);
    }
}
