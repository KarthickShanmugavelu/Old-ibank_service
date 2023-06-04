package com.ibank.service.dao;

import com.ibank.service.utilities.IBankUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
        String getAllTransactionsQuery = IBankUtility.getQueryFromFile("sql/getAllTransactions.sql");
        List<Map<String, Object>> transactions = jdbcTemplate.queryForList(getAllTransactionsQuery);
        return transactions;
    }

    public String deposit(int accountId, int amount) {
        String depositQuery = IBankUtility.getQueryFromFile("sql/deposit.sql");
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("account_id",accountId);
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
        String formattedDate = today.format(formatter);
        parameterSource.addValue("dateValue",formattedDate);
        parameterSource.addValue("type","Credit");
        parameterSource.addValue("amount",amount);
        parameterSource.addValue("status","Active");
        parameterSource.addValue("remarks","");
        namedParameterJdbcTemplate.update(depositQuery,parameterSource);
        return "Deposit Success";
    }
}
