package com.ibank.service.dao;

import com.ibank.service.dao.dto.AccountHolderDto;
import com.ibank.service.dao.dto.BeneficiaryDto;
import com.ibank.service.utilities.IBankUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BeneficiaryDAO {

    @Autowired
    @Qualifier("dbJdbcTemplate")
    JdbcTemplate jdbcTemplate;
    @Autowired
    @Qualifier("dbNamedParameterJdbcTemplate")
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    public String addBeneficiary(List<BeneficiaryDto> beneficiaryList) {
        String insertQuery = IBankUtility.getQueryFromFile("sql/insertBeneficiary.sql");
        for(BeneficiaryDto beneficiaryDto:beneficiaryList){
            MapSqlParameterSource params = new MapSqlParameterSource();
            params.addValue("account_id",beneficiaryDto.getAccountID());
            params.addValue("bene_account_id",beneficiaryDto.getBeneficiaryAccountId());
            params.addValue("bene_ifsccode",beneficiaryDto.getBeneficiaryIfscCode());
            params.addValue("bene_name",beneficiaryDto.getBeneficiaryName());
            params.addValue("status",beneficiaryDto.getStatus());
            namedParameterJdbcTemplate.update(insertQuery,params);
        }
        return "Beneficiary Created";
    }

    public List<Map<String, Object>> getAllBeneficiaries() {
        String getQuery = IBankUtility.getQueryFromFile("sql/getAllBeneficiaries.sql");
        List<Map<String, Object>> beneficisriesDtoList = jdbcTemplate.queryForList(getQuery);
        return beneficisriesDtoList;
    }

    public Map<String, Object> getBeneficiaryById(int id) {
        String getQueryById = IBankUtility.getQueryFromFile("sql/getBeneficiaryById.sql");
        Map<String,Integer> params = new HashMap<>();
        params.put("account_id",id);
        Map<String, Object> beneficiary = namedParameterJdbcTemplate.queryForMap(getQueryById,params);
        return beneficiary;
    }

    public String updateBeneficiary(int id, BeneficiaryDto beneficiaryDto) {
        String updateQuery=IBankUtility.getQueryFromFile("sql/updateBeneficiaryById.sql");
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("account_id",beneficiaryDto.getAccountID());
        params.addValue("bene_account_id",beneficiaryDto.getBeneficiaryAccountId());
        params.addValue("bene_ifsccode",beneficiaryDto.getBeneficiaryIfscCode());
        params.addValue("bene_name",beneficiaryDto.getBeneficiaryName());
        params.addValue("status",beneficiaryDto.getStatus());
        params.addValue("id",id);
        int updateStatus = namedParameterJdbcTemplate.update(updateQuery,params);
        if(updateStatus==1)
            return "Update Succes";
        else
            return "No rows were updated";
    }

    public String deleteBeneficiary(int id) {
        String deleteByIdQuery = IBankUtility.getQueryFromFile("sql/deleteBeneficiaryById.sql");
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("account_id",id);
        int deleteStatus =namedParameterJdbcTemplate.update(deleteByIdQuery,params);
        if(deleteStatus==1)
            return "Successfully Deleted";
        else
            return "No rows were deleted";
    }
}
