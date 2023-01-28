package com.example.kavosh.models.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class PersonDto {
    private Long id;
    @JsonProperty("firstName")
    private String fname;
    @JsonProperty("lastName")
    private String lname;
    @JsonProperty("username")
    private String username;
    @JsonProperty("password")
    private String password;
    private List<ProjectDto> projects;

}
