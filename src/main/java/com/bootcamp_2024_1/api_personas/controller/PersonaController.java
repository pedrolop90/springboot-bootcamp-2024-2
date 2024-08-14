package com.bootcamp_2024_1.api_personas.controller;

import com.bootcamp_2024_1.api_personas.dto.PersonaDto;
import com.bootcamp_2024_1.api_personas.mapper.PersonaMapper;
import com.bootcamp_2024_1.api_personas.persistencia.entity.PersonaEntity;
import com.bootcamp_2024_1.api_personas.persistencia.repository.PersonaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/personas")
@RequiredArgsConstructor
public class PersonaController {

    private final PersonaRepository personaRepository;
    private final PersonaMapper personaMapper;

    @GetMapping
    private List<PersonaDto> obtenerPersona() {
        return personaRepository
                .findAll()
                .stream()
                .map(personaEntity -> personaMapper.personaDtoToPersonaEntity(personaEntity))
                .collect(Collectors.toList());
    }


    @PostMapping
    private PersonaDto crearPersona(@RequestBody PersonaDto persona) {
        PersonaEntity personaEntity = this.personaRepository.save(
                personaMapper.personaEntityToPersonaDto(persona)
        );
        return personaMapper.personaDtoToPersonaEntity(personaEntity);
    }

}
