package com.example.kproject.service;

import com.example.kproject.model.Department;

import java.util.List;

public interface DepartmentService {

    void create(Department department);

    void update(Department department);

    void delete(Long id);

    Department getById(Long id);

    List<Department> getAllDepartments();

    List<Department> getAllByName(String name);

    List<Department> getAllByFloor(Long id);
}
