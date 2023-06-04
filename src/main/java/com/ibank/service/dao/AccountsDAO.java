package com.ibank.service.dao;

import com.ibank.service.dao.dto.AccountHolderDto;
import com.ibank.service.utilities.IBankUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AccountsDAO {

    @Autowired
    @Qualifier("dbJdbcTemplate")
    JdbcTemplate jdbcTemplate;
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

    public List<Map<String, Object>> getAccounts() {
        String getQuery = IBankUtility.getQueryFromFile("sql/getAccount.sql");
        List<Map<String, Object>> accountHolderDtoList = jdbcTemplate.queryForList(getQuery);
        return accountHolderDtoList;
    }

    public Map<String, Object> getAccountById(int id) {
        String getByIdQuery = IBankUtility.getQueryFromFile("sql/getAccountById.sql");
        Map<String,Integer> params = new HashMap<>();
        params.put("account_id",id);
        Map<String, Object> account = namedParameterJdbcTemplate.queryForMap(getByIdQuery,params);
        return account;
    }
}
