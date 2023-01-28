package com.example.kavosh.models.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class ProjectDto {
    private Long id;
    @JsonProperty("projectName")
    private String name;
    @JsonProperty("description")
    private String description;

}
