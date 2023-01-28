package com.example.kavosh.services.Impl;

import com.example.kavosh.exceptionhandlers.GlobalException;
import com.example.kavosh.models.entities.PersonEntity;
import com.example.kavosh.models.entities.ProjectEntity;
import com.example.kavosh.repositories.ProjectRepository;
import com.example.kavosh.services.PersonService;
import com.example.kavosh.services.ProjectService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    public static final Logger LOGGER = LoggerFactory.getLogger(ProjectServiceImpl.class);

    private final ProjectRepository projectRepository;
    private final PersonService personService;

    @Override
    @Transactional
    public void save(ProjectEntity projectEntity) {
        LOGGER.info("saving new project:{} to db", projectEntity);
        ProjectEntity savedProjectEntity = projectRepository.save(projectEntity);
        PersonEntity user = getUserFromSecurityContext();
        savedProjectEntity.setPerson(user);
    }

    @Override
    @Transactional
    public ProjectEntity findById(Long id) {
        return projectRepository.findById(id).orElseThrow(() -> new GlobalException("id.not.found"));
    }

    @Override
    @Transactional
    public ProjectEntity update(ProjectEntity projectEntity) {
        LOGGER.info("updating new project:{} to db", projectEntity);
        return projectRepository.save(projectEntity);
    }

    @Override
    @Transactional
    public List<ProjectEntity> findByPersonEntity() {
        LOGGER.info("fetching.all.projects.of.user.logged-in");
        PersonEntity personEntity = getUserFromSecurityContext();
        return projectRepository.findByPerson(personEntity);
    }

    public PersonEntity getUserFromSecurityContext() {
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return personService.getUser(username);
    }
}
