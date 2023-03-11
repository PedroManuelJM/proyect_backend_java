package com.example.proyectmatricula.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)

public class StudentDTO {

    private Integer idStudent;

    @NotNull
    @NotEmpty
    @Size(min= 3 , max=48)
    private String nameStudent;

    @NotNull
    @NotEmpty
    @Size(min= 3 , max=72)
    private String lastnameStudent;

    @NotNull
    @NotEmpty
    @Size(min=8)
    private String dniStudent;

    @NotNull
    @Min(value = 10)
    @Max(value = 70)
    private int ageStudent;
}
