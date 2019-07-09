package com.example.kproject.controller;


import com.example.kproject.model.Department;
import com.example.kproject.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentsController {

    private final DepartmentService departmentService;

    public DepartmentsController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    // Get All Departments
    @GetMapping
    public List<Department> getAllDepartments(){
        return departmentService.getAllDepartments();
    }

    // Create New Department
    @PostMapping
    public void createDepartment(@Valid @RequestBody Department department){
        departmentService.update(department);
    }

    // Delete An Existing Department
    @GetMapping("/{id}")
    public ResponseEntity<Department> deleteDepartment(@PathVariable(value = "id") Long departmentId){
        departmentService.delete(departmentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Search Department By Id
    @GetMapping("/search/id")
    public ResponseEntity<Department> getDepartmentById (@RequestParam(value = "id") Long departmentId){
        Department department = departmentService.getById(departmentId);
        return new ResponseEntity<>(department, HttpStatus.OK);
    }

    // Search Department By Name
    @GetMapping("/search/name")
    public List<Department> getDepartmentByName(@RequestParam(value = "name") String departmentName){
        return departmentService.getAllByName(departmentName);
    }

    // Search Department By Floor
    @GetMapping("/search/floor")
    public List<Department> getDepartmentByFloor(@RequestParam(value = "floor") Long departmentFloorId){
        return departmentService.getAllByFloor(departmentFloorId);
    }
}
