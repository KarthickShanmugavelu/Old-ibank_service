package com.ibank.service.service;

import com.ibank.service.dao.TransactionsDAO;
import com.ibank.service.dao.dto.TransactionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

@Service
public class TransactionsService {

    @Autowired
    TransactionsDAO dao;
    public List<Map<String,Object>> getTransactionSummary(int id) {
        return dao.getTransactionSummary(id);
    }

    public String deposit(int accountId, Long amount) {
        return dao.depositOrWithdraw(accountId,amount,"deposit");
    }

    public String withdraw(int accountId, Long amount) {
        return dao.depositOrWithdraw(accountId,amount,"withdraw");
    }

    public Map<String,Object> showBalance(int id){
        return dao.balance(id);

    }
}
