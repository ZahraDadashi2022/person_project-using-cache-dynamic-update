package com.example.kavosh.services;

import com.example.kavosh.base.BaseService;
import com.example.kavosh.models.entities.ProjectEntity;

import java.util.List;

public interface ProjectService extends BaseService<ProjectEntity, Long> {
    List<ProjectEntity> findByPersonEntity();

}
