package com.ibank.service.dao.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class AccountHolderDto {
    private int account_id;

    @NotNull(message = "Account holder name is required")
    @Pattern(regexp = "^[A-Za-z]",message = "Name must have only alphabets")
    private String account_name;

    private int phone;

    @Pattern(regexp = "^([a-zA-Z0-9_.-]+)@([a-zA-Z0-9-]+)\\.([a-zA-Z]{2,6})$", message = "Kindly enter a valid email id")
    private String email;

    @NotNull(message = "Account holder status is required")
    private String status;
}
