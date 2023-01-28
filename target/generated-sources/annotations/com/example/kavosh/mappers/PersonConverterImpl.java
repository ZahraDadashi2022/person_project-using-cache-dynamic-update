package com.example.kavosh.mappers;

import com.example.kavosh.models.dtos.PersonDto;
import com.example.kavosh.models.dtos.PersonDtoWithoutPassword;
import com.example.kavosh.models.dtos.ProjectDto;
import com.example.kavosh.models.entities.PersonEntity;
import com.example.kavosh.models.entities.ProjectEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-28T13:54:22+0330",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18.0.2.1 (Oracle Corporation)"
)
@Component
public class PersonConverterImpl implements PersonConverter {

    @Override
    public PersonEntity convertDtoToT(PersonDto d) {
        if ( d == null ) {
            return null;
        }

        PersonEntity personEntity = new PersonEntity();

        personEntity.setId( d.getId() );
        personEntity.setFname( d.getFname() );
        personEntity.setLname( d.getLname() );
        personEntity.setUsername( d.getUsername() );
        personEntity.setPassword( d.getPassword() );
        personEntity.setProjects( projectDtoListToProjectEntityList( d.getProjects() ) );

        return personEntity;
    }

    @Override
    public PersonDto convertTToDto(PersonEntity t) {
        if ( t == null ) {
            return null;
        }

        PersonDto personDto = new PersonDto();

        personDto.setId( t.getId() );
        personDto.setFname( t.getFname() );
        personDto.setLname( t.getLname() );
        personDto.setUsername( t.getUsername() );
        personDto.setPassword( t.getPassword() );
        personDto.setProjects( projectEntityListToProjectDtoList( t.getProjects() ) );

        return personDto;
    }

    @Override
    public List<PersonEntity> convertListDtoToListEntity(List<PersonDto> dList) {
        if ( dList == null ) {
            return null;
        }

        List<PersonEntity> list = new ArrayList<PersonEntity>( dList.size() );
        for ( PersonDto personDto : dList ) {
            list.add( convertDtoToT( personDto ) );
        }

        return list;
    }

    @Override
    public List<PersonDto> convertListEntityToListDto(List<PersonEntity> tList) {
        if ( tList == null ) {
            return null;
        }

        List<PersonDto> list = new ArrayList<PersonDto>( tList.size() );
        for ( PersonEntity personEntity : tList ) {
            list.add( convertTToDto( personEntity ) );
        }

        return list;
    }

    @Override
    public PersonDtoWithoutPassword convertEntityToDto(PersonEntity personEntity) {
        if ( personEntity == null ) {
            return null;
        }

        PersonDtoWithoutPassword personDtoWithoutPassword = new PersonDtoWithoutPassword();

        personDtoWithoutPassword.setId( personEntity.getId() );
        personDtoWithoutPassword.setFname( personEntity.getFname() );
        personDtoWithoutPassword.setLname( personEntity.getLname() );
        personDtoWithoutPassword.setUsername( personEntity.getUsername() );
        personDtoWithoutPassword.setProjects( projectEntityListToProjectDtoList( personEntity.getProjects() ) );

        return personDtoWithoutPassword;
    }

    @Override
    public PersonEntity convertDtoToEntity(PersonDtoWithoutPassword personDtoWithoutPassword) {
        if ( personDtoWithoutPassword == null ) {
            return null;
        }

        PersonEntity personEntity = new PersonEntity();

        personEntity.setId( personDtoWithoutPassword.getId() );
        personEntity.setFname( personDtoWithoutPassword.getFname() );
        personEntity.setLname( personDtoWithoutPassword.getLname() );
        personEntity.setUsername( personDtoWithoutPassword.getUsername() );
        personEntity.setProjects( projectDtoListToProjectEntityList( personDtoWithoutPassword.getProjects() ) );

        return personEntity;
    }

    protected ProjectEntity projectDtoToProjectEntity(ProjectDto projectDto) {
        if ( projectDto == null ) {
            return null;
        }

        ProjectEntity projectEntity = new ProjectEntity();

        projectEntity.setId( projectDto.getId() );
        projectEntity.setName( projectDto.getName() );
        projectEntity.setDescription( projectDto.getDescription() );

        return projectEntity;
    }

    protected List<ProjectEntity> projectDtoListToProjectEntityList(List<ProjectDto> list) {
        if ( list == null ) {
            return null;
        }

        List<ProjectEntity> list1 = new ArrayList<ProjectEntity>( list.size() );
        for ( ProjectDto projectDto : list ) {
            list1.add( projectDtoToProjectEntity( projectDto ) );
        }

        return list1;
    }

    protected ProjectDto projectEntityToProjectDto(ProjectEntity projectEntity) {
        if ( projectEntity == null ) {
            return null;
        }

        ProjectDto projectDto = new ProjectDto();

        projectDto.setId( projectEntity.getId() );
        projectDto.setName( projectEntity.getName() );
        projectDto.setDescription( projectEntity.getDescription() );

        return projectDto;
    }

    protected List<ProjectDto> projectEntityListToProjectDtoList(List<ProjectEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<ProjectDto> list1 = new ArrayList<ProjectDto>( list.size() );
        for ( ProjectEntity projectEntity : list ) {
            list1.add( projectEntityToProjectDto( projectEntity ) );
        }

        return list1;
    }
}
