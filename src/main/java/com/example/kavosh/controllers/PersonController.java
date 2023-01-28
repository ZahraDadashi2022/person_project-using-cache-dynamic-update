package com.example.kavosh.controllers;

import com.example.kavosh.exceptionhandlers.GlobalException;
import com.example.kavosh.mappers.PersonConverter;
import com.example.kavosh.models.dtos.PersonDto;
import com.example.kavosh.models.dtos.PersonDtoWithoutPassword;
import com.example.kavosh.services.PersonService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class PersonController {
    public static final Logger LOGGER = LoggerFactory.getLogger(PersonController.class);

    private final PersonService personService;
    private final PersonConverter personConverter;

    @PostMapping
    public String savePerson(@RequestBody PersonDto personDto) {
        LOGGER.info("saving person was done successfully:{} ", personDto);
        personService.save(personConverter.convertDtoToT(personDto));
        return "saving person was done successfully";
    }

    @PutMapping
    public PersonDto updatePerson(@RequestBody PersonDto personDto) {
        LOGGER.info("updating person was done successfully:{} ", personDto);
        return personConverter.convertTToDto(personService.update(personConverter.convertDtoToT(personDto)));
    }

    @GetMapping("/{id}")
    public PersonDtoWithoutPassword findById(@PathVariable Long id) {
        LOGGER.info("fetching data: project and user by user id;{} ",id);
        PersonDtoWithoutPassword personDto = personConverter.convertEntityToDto(personService.findById(id));
        if (personDto == null) {
            throw new GlobalException("person.id.is.not.found : " + id);
        }
        return personDto;
    }
}
