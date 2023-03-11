package com.example.proyectmatricula.service;

import com.example.proyectmatricula.model.Student;

import java.util.List;

public interface IStudentService extends ICRUD<Student,Integer> {

    List<Student> report();
}
