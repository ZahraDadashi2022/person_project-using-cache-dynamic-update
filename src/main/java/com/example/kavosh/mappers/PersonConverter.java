package com.example.kavosh.mappers;

import com.example.kavosh.base.BaseMapper;
import com.example.kavosh.models.dtos.PersonDto;
import com.example.kavosh.models.dtos.PersonDtoWithoutPassword;
import com.example.kavosh.models.entities.PersonEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonConverter extends BaseMapper<PersonEntity, PersonDto> {

    PersonDtoWithoutPassword convertEntityToDto(PersonEntity personEntity);

    PersonEntity convertDtoToEntity(PersonDtoWithoutPassword personDtoWithoutPassword);

}
