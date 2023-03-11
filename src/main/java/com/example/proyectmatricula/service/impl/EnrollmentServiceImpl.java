package com.example.proyectmatricula.service.impl;

import com.example.proyectmatricula.model.Enrollment;
import com.example.proyectmatricula.repo.IEnrollmentRepo;
import com.example.proyectmatricula.repo.IGenericRepo;
import com.example.proyectmatricula.service.IEnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnrollmentServiceImpl  extends  CRUDImpl<Enrollment,Integer> implements IEnrollmentService {

    private final IEnrollmentRepo repo;
    @Override
    protected IGenericRepo<Enrollment, Integer> getRepo() {
        return repo;
    }
}
