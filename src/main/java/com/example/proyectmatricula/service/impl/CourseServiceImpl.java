package com.example.proyectmatricula.service.impl;
import com.example.proyectmatricula.model.Course;
import com.example.proyectmatricula.repo.IGenericRepo;
import com.example.proyectmatricula.repo.ICourseRepo;
import com.example.proyectmatricula.service.ICourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl extends CRUDImpl<Course,Integer> implements ICourseService {


    private final ICourseRepo repo;
    @Override
    protected IGenericRepo<Course, Integer> getRepo() {
        return repo;
    }
}
