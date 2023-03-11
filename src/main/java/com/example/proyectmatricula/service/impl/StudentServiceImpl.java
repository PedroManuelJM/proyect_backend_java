package com.example.proyectmatricula.service.impl;
import com.example.proyectmatricula.model.Student;
import com.example.proyectmatricula.repo.IGenericRepo;
import com.example.proyectmatricula.repo.IStudentRepo;
import com.example.proyectmatricula.service.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl extends CRUDImpl<Student,Integer> implements IStudentService {


    private final IStudentRepo repo;
    @Override
    protected IGenericRepo<Student, Integer> getRepo() {
        return repo;
    }

    @Override
    public List<Student> report() {

        Comparator<Student> inverse=(x1, x2) -> x2.getAge()-x1.getAge();
        return  repo.findAll().stream().sorted(inverse).collect(Collectors.toList());

    }

}
