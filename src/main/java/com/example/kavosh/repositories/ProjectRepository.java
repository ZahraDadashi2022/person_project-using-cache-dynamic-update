package com.example.kavosh.repositories;


import com.example.kavosh.base.BaseRepository;
import com.example.kavosh.models.entities.PersonEntity;
import com.example.kavosh.models.entities.ProjectEntity;

import java.util.List;

public interface ProjectRepository extends BaseRepository<ProjectEntity,Long> {
    List<ProjectEntity> findByPerson(PersonEntity personEntity);

}
