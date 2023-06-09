package com.example.proyectmatricula.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class EnrollmentDetail {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEnrollmentDetail;

    @ManyToOne
    @JoinColumn(name = "idEnrollment",nullable = false)
    private Enrollment enrollment;

    @ManyToOne
    @JoinColumn(name = "idCourse",nullable = false)
    private Course course;

    @Column(nullable = false)
    private String classroom;

}
