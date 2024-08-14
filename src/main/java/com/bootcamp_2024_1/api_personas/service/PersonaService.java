package com.bootcamp_2024_1.api_personas.service;

import com.bootcamp_2024_1.api_personas.dto.PersonaDto;
import com.bootcamp_2024_1.api_personas.error.ErrorPersonaMayorEdad;
import com.bootcamp_2024_1.api_personas.mapper.PersonaMapper;
import com.bootcamp_2024_1.api_personas.persistencia.entity.PersonaEntity;
import com.bootcamp_2024_1.api_personas.persistencia.repository.PersonaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonaService {

    private final Long MAYOR_EDAD = 18L;

    private final PersonaRepository personaRepository;
    private final PersonaMapper personaMapper;

    public List<PersonaDto> obtenerPersonas() {
        return personaRepository
                .findAll()
                .stream()
                .map(personaEntity -> personaMapper.personaEntityToPersonaDto(personaEntity))
                .collect(Collectors.toList());
    }

    public PersonaDto crearPersona(PersonaDto persona) {
        if (persona.getEdad() < MAYOR_EDAD || persona.getEdad() > 99) {
            throw new ErrorPersonaMayorEdad("El rango esta entre 18 y 99");
        }
        PersonaEntity personaEntity = this.personaRepository.save(
                personaMapper.personaDtoToPersonaEntity(persona)
        );
        return personaMapper.personaEntityToPersonaDto(personaEntity);
    }

}
