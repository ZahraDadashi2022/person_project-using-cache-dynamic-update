package com.example.kavosh.controllers;

import com.example.kavosh.exceptionhandlers.GlobalException;
import com.example.kavosh.mappers.ProjectConverter;
import com.example.kavosh.models.dtos.ProjectDto;
import com.example.kavosh.services.ProjectService;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectController {
    public static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(ProjectController.class);
    private final ProjectService projectService;
    private final ProjectConverter projectConverter;

    @PostMapping
    public String saveProject(@RequestBody ProjectDto projectDto) {
        LOGGER.info("saving project was done successfully:{}", projectDto);
        projectService.save(projectConverter.convertDtoToT(projectDto));
        return "saving project was done successfully";
    }

    @GetMapping("/{id}")
    public ProjectDto findById(@PathVariable Long id) {
        LOGGER.info("getting project by project id:{} ",id);
        ProjectDto projectDto = projectConverter.convertTToDto(projectService.findById(id));
        if (projectDto == null) {
            throw new GlobalException("project.id.is.not.found : " + id);
        }
        return projectDto;
    }

    @GetMapping
    public List<ProjectDto> getProjects() {
        LOGGER.info("fetching.all.projects.of.user.logged-in");
        return projectConverter.convertListEntityToListDto(projectService.findByPersonEntity());
    }
}
