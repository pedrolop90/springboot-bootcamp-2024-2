package com.bootcamp_2024_1.api_personas.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonaDto {

    private Long id;
    private String nombre;

    private String apellido;

    private Long edad;
}
