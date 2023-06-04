package com.ibank.service.dao.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AccountHolderDto {
    private int account_id;

    @NotNull(message = "Account holder name is required")
    @Pattern(regexp = "^[A-Za-z]",message = "Name must have only alphabets")
    private String account_name;

    @Pattern(regexp = "^[0-9]+$", message = "Phone number must have only numbers")
    private int phone;

    @Pattern(regexp = "^([a-zA-Z0-9_.-]+)@([a-zA-Z0-9-]+)\\.([a-zA-Z]{2,6})$", message = "Kindly enter a valid email id")
    private String email;

    @NotNull(message = "Account holder status is required")
    private String status;
}
