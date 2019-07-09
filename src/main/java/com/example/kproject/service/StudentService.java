package com.example.kproject.service;

import com.example.kproject.model.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();

    void create(Student student);

    void update(Student student);

    void delete(Long studentId);

    Student getById(Long id);

    List<Student> getByName(String name);

    List<Student> getBySurname(String surname);

    List<Student> getStudentByGroupId(Long groupId);

}
