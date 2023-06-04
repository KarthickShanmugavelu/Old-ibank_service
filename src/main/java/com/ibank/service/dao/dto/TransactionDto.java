package com.ibank.service.dao.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class TransactionDto {

    private int id;
    private int accountId;
    private String date;
    private String type;
    private int amount;
    private String status;
    private String remarks;
}
