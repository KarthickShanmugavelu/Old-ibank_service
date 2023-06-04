package com.ibank.service.dao;

import com.ibank.service.utilities.IBankUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TransactionsDAO {
    @Autowired
    @Qualifier("dbJdbcTemplate")
    JdbcTemplate jdbcTemplate;
    @Autowired
    @Qualifier("dbNamedParameterJdbcTemplate")
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    public List<Map<String, Object>> getTransactionSummary(int id) {
        String getAllTransactionsQuery = IBankUtility.getQueryFromFile("sql/getAllTransactionsById.sql");
        Map<String,Integer> params = new HashMap<>();
        params.put("account_id",id);
        List<Map<String, Object>> transactions = namedParameterJdbcTemplate.queryForList(getAllTransactionsQuery,params);
        return transactions;
    }

    public String depositOrWithdraw(int accountId, Long amount,String operation) {
        String depositQuery = IBankUtility.getQueryFromFile("sql/deposit.sql");
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("account_id",accountId);
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
        String formattedDate = today.format(formatter);
        parameterSource.addValue("dateValue",formattedDate);
        if(operation.equals("deposit")) {
            parameterSource.addValue("type", "Credit");
        }else{
            parameterSource.addValue("type", "Debit");
        }
        parameterSource.addValue("amount",amount);
        parameterSource.addValue("status","Active");
        parameterSource.addValue("remarks","");
        namedParameterJdbcTemplate.update(depositQuery,parameterSource);
        updateBalance(accountId,amount,operation);
        return "Transaction Success";
    }

    private void updateBalance(int accountId, Long amount,String operation) {
        String updateBalanceQuery = null;
        Map<String, Object> oldBalanceMap=null;
        Long newBalance=null;
        String getBalanceQuery = IBankUtility.getQueryFromFile("sql/getBalanceQuery.sql");
        Map<String,Integer> params = new HashMap<>();
        params.put("account_id",accountId);
        try {
            oldBalanceMap = namedParameterJdbcTemplate.queryForMap(getBalanceQuery, params);
            updateBalanceQuery = IBankUtility.getQueryFromFile("sql/updateBalanceQuery.sql");
            if(operation.equals("deposit")){
                newBalance = amount+(Long)oldBalanceMap.get("Balance");
            }else{
                newBalance = amount-(Long)oldBalanceMap.get("Balance");
            }
        }catch(EmptyResultDataAccessException e){
            updateBalanceQuery= IBankUtility.getQueryFromFile("sql/insertBalanceQuery.sql");
            newBalance=amount;
        }
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("newBalance",newBalance);
        parameterSource.addValue("account_id",accountId);
        namedParameterJdbcTemplate.update(updateBalanceQuery,parameterSource);
    }

    public Map<String, Object> balance(int id) {
        String getBalanceQuery = IBankUtility.getQueryFromFile("sql/getBalanceQuery.sql");
        Map<String,Integer> params = new HashMap<>();
        params.put("account_id",id);
        Map<String, Object> balance = namedParameterJdbcTemplate.queryForMap(getBalanceQuery, params);
        return balance;
    }
}
