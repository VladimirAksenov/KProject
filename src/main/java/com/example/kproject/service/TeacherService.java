package com.example.kproject.service;

import com.example.kproject.model.Teacher;

import java.util.List;

public interface TeacherService {

    void create(Teacher teacher);

    void update(Teacher teacher);

    void delete(Long id);

    List<Teacher> getAllTeachers();

    Teacher getTeacherById (Long id);

    List<Teacher> getAllTeachersByName(String name);

    List<Teacher> getAllTeachersBySurname (String surname);

    List<Teacher> getAllTeachersByDepartmentId (Long departmentId);
}
