package com.ibank.service.dao;

import com.ibank.service.dao.dto.AccountHolderDto;
import com.ibank.service.utilities.IBankUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.security.spec.NamedParameterSpec;
import java.util.List;

@Repository
public class TransactionDAO {

    @Autowired
    @Qualifier("dbNamedParameterJdbcTemplate")
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    public String insertAccountHolder(List<AccountHolderDto> accountHolderDtoList) {
        String insertQuery = IBankUtility.getQueryFromFile("sql/insertAccount.sql");
        for(AccountHolderDto accountHolderDto:accountHolderDtoList){
            MapSqlParameterSource params = new MapSqlParameterSource();
            params.addValue("account_name",accountHolderDto.getAccount_name());
            params.addValue("phone",accountHolderDto.getPhone());
            params.addValue("email",accountHolderDto.getEmail());
            params.addValue("status",accountHolderDto.getStatus());
            namedParameterJdbcTemplate.update(insertQuery,params);
        }
        return "Account Created";
    }
}
