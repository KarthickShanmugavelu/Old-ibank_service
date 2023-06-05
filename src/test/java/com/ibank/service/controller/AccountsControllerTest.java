package com.ibank.service.controller;

import com.ibank.service.dao.dto.AccountHolderDto;
import com.ibank.service.service.AccountsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AccountsControllerTest {

    @InjectMocks
    AccountsController accountsController;
    @Mock
    AccountsService accountsService;

    @Test
    void getAccountById(){
        Map<String, Object> expectedMap = new HashMap<>();
        expectedMap.put("account_id",1);
        expectedMap.put("account_name","Vinod");
        expectedMap.put("phone",12345);
        expectedMap.put("email","vinod@gmail.com");
        expectedMap.put("status","Active");
        when(accountsService.getAccountById(anyInt())).thenReturn(expectedMap);
        Map<String, Object> actualMap = accountsService.getAccountById(1);
        ResponseEntity<Map<String, Object>> actualResult = new ResponseEntity<>(actualMap, HttpStatus.OK);
        ResponseEntity<Map<String, Object>> expectedResult = new ResponseEntity<>(expectedMap, HttpStatus.OK);
        Assertions.assertNotNull(actualResult);
        Assertions.assertEquals(expectedResult,actualResult);
    }

    @Test
    void addCustomer(){
        AccountHolderDto accountHolderDto = new AccountHolderDto();
        accountHolderDto.setAccount_name("Vinod");
        accountHolderDto.setPhone(12345);
        accountHolderDto.setEmail("vinod@gmail.com");
        accountHolderDto.setStatus("Active");
        List<AccountHolderDto> inputList = new ArrayList<>();
        inputList.add(accountHolderDto);
        when(accountsService.insertAccountHolder(any())).thenReturn("Account Created");
        ResponseEntity<String> actualResult = new ResponseEntity<>(accountsService.insertAccountHolder(inputList),HttpStatus.OK);
        ResponseEntity<String> expectedResult = new ResponseEntity<>("Account Created",HttpStatus.OK);
        Assertions.assertNotNull(actualResult);
        Assertions.assertEquals(expectedResult,actualResult);
    }

}
