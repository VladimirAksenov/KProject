package com.example.kproject.service;


import com.example.kproject.exception.NoRecordFoundException;
import com.example.kproject.exception.NoRecordFoundToUpdate;
import com.example.kproject.model.Department;
import com.example.kproject.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public void create(Department department) {
        departmentRepository.save(department);
    }

    @Override
    public void update(Department department) {
        Optional<Department> founded = departmentRepository.findById(department.getId());
        if (founded.isPresent()) {
            departmentRepository.save(department);
        } else {
            throw new NoRecordFoundToUpdate("There Is No Department With Id = " + department.getId());
        }
    }

    @Override
    public void delete(Long departmentId) {
        Optional founded = departmentRepository.findById(departmentId);
        if (founded.isPresent()) {
            departmentRepository.deleteById(departmentId);
        } else {
            throw new NoRecordFoundException("Department Not Found With Id = " + departmentId);
        }
    }

    @Override
    public Department getById(Long id) {
        Optional optional = departmentRepository.findById(id);
        if (optional.isPresent()) {
            return (Department) optional.get();
        } else {
            throw new NoRecordFoundException("Not Found Department With Id = " + id);
        }
    }

    @Override
    public List<Department> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();
        if (departments == null || departments.isEmpty()) {
            throw new NoRecordFoundException("Departments Have Not Been Created Yet");
        } else {
            return departments;
        }
    }

    @Override
    public List<Department> getAllByName(String name) {
        List<Department> departments = departmentRepository.getAllByName(name);
        if (departments == null || departments.isEmpty()) {
            throw new NoRecordFoundException("Not Found Department With Name = " + name);
        } else {
            return departments;
        }
    }

    @Override
    public List<Department> getAllByFloor(Long floorId) {
        List<Department> departments = departmentRepository.getAllByFloor(floorId);
        if (departments == null || departments.isEmpty()) {
            throw new NoRecordFoundException("Not found Department On The Floor = " + floorId);
        } else {
            return departments;
        }
    }
}

