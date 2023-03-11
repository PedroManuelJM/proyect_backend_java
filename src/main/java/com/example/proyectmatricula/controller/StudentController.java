package com.example.proyectmatricula.controller;
import com.example.proyectmatricula.dto.CourseDTO;
import com.example.proyectmatricula.dto.StudentDTO;
import com.example.proyectmatricula.model.Course;
import com.example.proyectmatricula.model.Student;
import com.example.proyectmatricula.service.IStudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final IStudentService service;

    @Qualifier("studentMapper")
    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<StudentDTO>> readAll() throws Exception{
        List<StudentDTO> list = service.readAll().stream().map(this::convertToDto).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> readById(@PathVariable("id") Integer id) throws Exception{
        Student obj = service.readById(id);
        return new ResponseEntity<>(this.convertToDto(obj),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StudentDTO> create(@RequestBody StudentDTO dto) throws Exception{
        Student obj = service.save(this.convertToEntity(dto));
        return new ResponseEntity<>(this.convertToDto(obj),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> update(@PathVariable("id") Integer id,@RequestBody StudentDTO dto) throws Exception{
        dto.setIdStudent(id);
        Student obj = service.save(convertToEntity(dto));
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private StudentDTO convertToDto(Student obj){
        return mapper.map(obj,StudentDTO.class);
    }

    private Student convertToEntity(StudentDTO dto){
        return mapper.map(dto,Student.class);
    }

    // reporte de ordernar estudiantes por edad descendente
    @GetMapping("/report")
    public ResponseEntity<List<StudentDTO>> reportstudentage(){
        List<StudentDTO> list =service.report().stream().map(student -> mapper.map(student,StudentDTO.class)).collect(Collectors.toList());
        return new ResponseEntity<>( list,HttpStatus.OK);
    }

}

