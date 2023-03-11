package com.example.proyectmatricula.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity


public class Enrollment {

  @EqualsAndHashCode.Include
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idEnrollment;

  @Column(nullable = false)
  private LocalDateTime datetime;

  @ManyToOne
  @JoinColumn(name = "idStudent", nullable = false, foreignKey = @ForeignKey(name = "FK_Enrollment_Student"))
  private Student student;

  @Column(nullable = false)
  private boolean status;

  @OneToMany(mappedBy = "enrollment",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private List<EnrollmentDetail> details;




}
