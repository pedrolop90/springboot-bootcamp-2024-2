package com.bootcamp_2024_1.api_personas.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetails {

    private int statusCode;
    private String message;
    private String details;

}
