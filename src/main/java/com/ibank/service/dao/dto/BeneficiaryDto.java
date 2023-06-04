package com.ibank.service.dao.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BeneficiaryDto {

    private int accountID;
    private int beneficiaryAccountId;
    @Pattern(regexp = "^[A-Za-z0-9]+$",message = "IFSC code must have only Alphanumeric Characters")
    private String beneficiaryIfscCode;
    @Pattern(regexp = "^[A-Za-z]+$",message = "Name must have only alphabets")
    private String beneficiaryName;
    @NotNull(message = "Status cannot be null")
    private String status;

}
