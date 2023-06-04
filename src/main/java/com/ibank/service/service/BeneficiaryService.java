package com.ibank.service.service;

import com.ibank.service.dao.BeneficiaryDAO;
import com.ibank.service.dao.dto.AccountHolderDto;
import com.ibank.service.dao.dto.BeneficiaryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BeneficiaryService {

    @Autowired
    BeneficiaryDAO dao;
    public String addBeneficiary(List<BeneficiaryDto> beneficiaryList) {
        return dao.addBeneficiary(beneficiaryList);
    }

    public List<Map<String, Object>> getAllBeneficiaries() {
        return dao.getAllBeneficiaries();
    }

    public Map<String, Object> getBeneficiaryById(int id) {
        return dao.getBeneficiaryById(id);
    }

    public String updateBeneficiary(int id, BeneficiaryDto beneficiaryDto) {
        return dao.updateBeneficiary(id,beneficiaryDto);
    }

    public String deleteBeneficiary(int id) {
        return dao.deleteBeneficiary(id);
    }
}
