package com.example.proyectmatricula.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity

public class Course {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCourse;

    @Column(length = 128, nullable = false)
    private String name;

    @Column(length = 24, nullable = false)
    private String initial;

    @Column(nullable = false)
    private boolean status;
}
