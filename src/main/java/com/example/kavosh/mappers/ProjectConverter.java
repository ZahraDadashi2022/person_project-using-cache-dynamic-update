package com.example.kavosh.mappers;

import com.example.kavosh.base.BaseMapper;
import com.example.kavosh.models.dtos.ProjectDto;
import com.example.kavosh.models.entities.ProjectEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProjectConverter extends BaseMapper<ProjectEntity, ProjectDto> {

}
