package com.example.proyectmatricula.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)

public class GroupCoursebyStudent {

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String nameCourse;
    private String nameStudent;

}
