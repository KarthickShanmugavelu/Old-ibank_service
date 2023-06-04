package com.ibank.service.controller;

import com.ibank.service.dao.dto.AccountHolderDto;
import com.ibank.service.dao.dto.BeneficiaryDto;
import com.ibank.service.service.BeneficiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/beneficiary")
@Validated
public class BeneficiaryController {

    @Autowired
    BeneficiaryService service;

    @PostMapping("/addBeneficiary")
    public ResponseEntity<String> addBeneficiary(@RequestBody @Valid List<BeneficiaryDto> beneficiaryList) {
        String insertionStatus = service.addBeneficiary(beneficiaryList);
        return new ResponseEntity<>(insertionStatus, HttpStatus.OK);
    }

    @GetMapping("/getAllBeneficiaries")
    public ResponseEntity<List<Map<String, Object>>> getAllBeneficiaries() {
        List<Map<String, Object>> beneficiariesList = service.getAllBeneficiaries();
        return new ResponseEntity<>(beneficiariesList, HttpStatus.OK);
    }

    @GetMapping("/getBeneficiaryById/{id}")
    public ResponseEntity<Map<String, Object>> getBeneficiaryById(@PathVariable("id") int id) {
        Map<String, Object> beneficiary = service.getBeneficiaryById(id);
        return new ResponseEntity<>(beneficiary, HttpStatus.OK);
    }

    @PutMapping("/updateBeneficiary/{id}")
    public ResponseEntity<String> updateBeneficiary(@PathVariable("id") int id, @RequestBody @Valid BeneficiaryDto beneficiaryDto) {
        String updateStatus = service.updateBeneficiary(id, beneficiaryDto);
        return new ResponseEntity<>(updateStatus, HttpStatus.OK);
    }

    @DeleteMapping("/deleteBeneficiaryById/{id}")
    public ResponseEntity<String> deleteBeneficiary(@PathVariable("id") int id) {
        String deleteStatus = service.deleteBeneficiary(id);
        return new ResponseEntity<>(deleteStatus, HttpStatus.OK);
    }


}
