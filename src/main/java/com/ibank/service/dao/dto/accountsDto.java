package com.ibank.service.dao.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Pattern;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class accountsDto {
    private int account_id;

    @Pattern("^[a-zA-Z")
    private String account_name;
    private int phone;
    private String email;
    private String status;
}
