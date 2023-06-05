package com.ibank.service.exceptionHandling;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomMessage {
    @JsonProperty("message")
    private String exceptionMessage;
}
