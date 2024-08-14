package com.bootcamp_2024_1.api_personas.controller;

import com.bootcamp_2024_1.api_personas.dto.PersonaDto;
import com.bootcamp_2024_1.api_personas.service.PersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personas")
@RequiredArgsConstructor
public class PersonaController {

    private final PersonaService personaService;

    @PostMapping
    private PersonaDto crearPersona(@RequestBody PersonaDto persona) {
        return personaService.crearPersona(persona);
    }

    @GetMapping
    private List<PersonaDto> obtenerPersona() {
        return personaService.obtenerPersonas();
    }


}
