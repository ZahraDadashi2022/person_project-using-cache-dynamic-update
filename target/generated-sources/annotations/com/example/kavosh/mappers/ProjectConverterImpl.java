package com.example.kavosh.mappers;

import com.example.kavosh.models.dtos.ProjectDto;
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
public class ProjectConverterImpl implements ProjectConverter {

    @Override
    public ProjectEntity convertDtoToT(ProjectDto d) {
        if ( d == null ) {
            return null;
        }

        ProjectEntity projectEntity = new ProjectEntity();

        projectEntity.setId( d.getId() );
        projectEntity.setName( d.getName() );
        projectEntity.setDescription( d.getDescription() );

        return projectEntity;
    }

    @Override
    public ProjectDto convertTToDto(ProjectEntity t) {
        if ( t == null ) {
            return null;
        }

        ProjectDto projectDto = new ProjectDto();

        projectDto.setId( t.getId() );
        projectDto.setName( t.getName() );
        projectDto.setDescription( t.getDescription() );

        return projectDto;
    }

    @Override
    public List<ProjectEntity> convertListDtoToListEntity(List<ProjectDto> dList) {
        if ( dList == null ) {
            return null;
        }

        List<ProjectEntity> list = new ArrayList<ProjectEntity>( dList.size() );
        for ( ProjectDto projectDto : dList ) {
            list.add( convertDtoToT( projectDto ) );
        }

        return list;
    }

    @Override
    public List<ProjectDto> convertListEntityToListDto(List<ProjectEntity> tList) {
        if ( tList == null ) {
            return null;
        }

        List<ProjectDto> list = new ArrayList<ProjectDto>( tList.size() );
        for ( ProjectEntity projectEntity : tList ) {
            list.add( convertTToDto( projectEntity ) );
        }

        return list;
    }
}
