package com.example.proyectmatricula.controller;

import com.example.proyectmatricula.dto.EnrollmentDTO;
import com.example.proyectmatricula.dto.GroupCoursebyStudent;
import com.example.proyectmatricula.model.Enrollment;
import com.example.proyectmatricula.service.IEnrollmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/enrollments")
@RequiredArgsConstructor
public class EnrollmentController {
    private final IEnrollmentService service;

    @Qualifier("enrollmentMapper")
    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<EnrollmentDTO>> readAll() throws Exception{
        List<EnrollmentDTO> list = service.readAll().stream().map(this::convertToDto).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnrollmentDTO> readById(@PathVariable("id") Integer id) throws Exception{
        Enrollment obj = service.readById(id);
        return new ResponseEntity<>(this.convertToDto(obj),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EnrollmentDTO> create(@Valid @RequestBody EnrollmentDTO dto) throws Exception{
        Enrollment obj = service.save(this.convertToEntity(dto));
        return new ResponseEntity<>(this.convertToDto(obj),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnrollmentDTO> update(@Valid @PathVariable("id") Integer id,@RequestBody EnrollmentDTO dto) throws Exception{
        dto.setIdEnrollment(id);
        Enrollment obj = service.save(convertToEntity(dto));
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private EnrollmentDTO convertToDto(Enrollment obj){
        return mapper.map(obj,EnrollmentDTO.class);
    }

    private Enrollment convertToEntity(EnrollmentDTO dto){
        return mapper.map(dto,Enrollment.class);
    }

    // Listar cursos matriculados y con los estudiantes

    @GetMapping("/group")
    public ResponseEntity<?> groupStudent() throws Exception{

        Map<String, List<GroupCoursebyStudent>> list = service.readAll()
                .stream()
                .map(enrollment -> {
                    return new GroupCoursebyStudent(enrollment.getDetails().get(0).getCourse().getName(), enrollment.getStudent().getName());
                })
                .collect(Collectors.groupingBy(
                        GroupCoursebyStudent::getNameCourse
                ));
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}

