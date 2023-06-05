package com.ibank.service.controller;

import com.ibank.service.dao.TransactionsDAO;
import com.ibank.service.service.TransactionsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TransactionsControllerTest {

    @InjectMocks
    private TransactionsController transactionsController;

    @Mock
    TransactionsService transactionsService;

    @Test
    void getTransactionSummaryTest() {
        List<Map<String, Object>> expectedResultList = new ArrayList<>();
        Map<String, Object> expectedMap = new HashMap<>();
        expectedMap.put("id", 1);
        expectedMap.put("account_id", 1);
        expectedMap.put("date", "18-Sep-22");
        expectedMap.put("type", "Credit");
        expectedMap.put("amount", 1000);
        expectedMap.put("status", "Success");
        expectedResultList.add(expectedMap);
        when(transactionsService.getTransactionSummary(anyInt())).thenReturn(expectedResultList);
        ResponseEntity<List<Map<String, Object>>> actualResult = transactionsController.getTransactionSummary(1);
        ResponseEntity<List<Map<String, Object>>> expectedResult = new ResponseEntity<>(expectedResultList, HttpStatus.OK);
        Assertions.assertNotNull(actualResult);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void depositTest(){
        when(transactionsService.deposit(anyInt(),anyLong())).thenReturn("Transaction Success");
        String actualResultMessage = transactionsService.deposit(2,new Long(1000));
        ResponseEntity<String> actualResult = new ResponseEntity<>(actualResultMessage,HttpStatus.OK);
        ResponseEntity<String> expectedResult = new ResponseEntity<>("Transaction Success",HttpStatus.OK);
        Assertions.assertNotNull(actualResult);
        Assertions.assertEquals(expectedResult,actualResult);
    }
}
