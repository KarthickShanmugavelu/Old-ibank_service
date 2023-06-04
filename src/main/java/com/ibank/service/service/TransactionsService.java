package com.ibank.service.service;

import com.ibank.service.dao.TransactionDAO;
import com.ibank.service.dao.dto.AccountHolderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionsService {

@Autowired
TransactionDAO transactionDAO;

    public String insertAccountHolder(List<AccountHolderDto> accountHolderDtoList) {
        return transactionDAO.insertAccountHolder(accountHolderDtoList);
    }
}
