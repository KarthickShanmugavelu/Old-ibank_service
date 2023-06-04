package com.ibank.service.service;

import com.ibank.service.dao.AccountsDAO;
import com.ibank.service.dao.dto.AccountHolderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AccountsService {

@Autowired
AccountsDAO accountsDAO;

    public String insertAccountHolder(List<AccountHolderDto> accountHolderDtoList) {
        return accountsDAO.insertAccountHolder(accountHolderDtoList);
    }

    public List<Map<String, Object>> getAccounts() {
        return accountsDAO.getAccounts();
    }

    public Map<String, Object> getAccountById(int id) {
        return accountsDAO.getAccountById(id);
    }
}
