package com.ibank.service.service;

import com.ibank.service.dao.TransactionsDAO;
import com.ibank.service.dao.dto.TransactionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TransactionsService {

    @Autowired
    TransactionsDAO dao;
    public List<Map<String,Object>> getTransactionSummary(int id) {
        return dao.getTransactionSummary(id);
    }

    public String deposit(int accountId, int amount) {
        return dao.deposit(accountId,amount);
    }
}
