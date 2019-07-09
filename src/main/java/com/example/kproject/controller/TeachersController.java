package com.example.kproject.controller;


import com.example.kproject.model.Teacher;
import com.example.kproject.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/teachers")
public class TeachersController {

    private final TeacherService teacherService;

    public TeachersController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    //Get All Teachers
    @GetMapping
    public List<Teacher> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    // Create New Student
    @PostMapping
    public void createTeacher(@Valid @RequestBody Teacher teacher) {
        teacherService.create(teacher);
    }

    // Update An Existing Teacher
    @PutMapping
    public void updateTeacher(@Valid @RequestBody Teacher teacherDetails) {
        teacherService.update(teacherDetails);
    }

    // Delete An Existing Teacher
    @DeleteMapping("{id}")
    public ResponseEntity<Teacher> deleteTeacher(@PathVariable(value = "id") Long teacherId) {
        teacherService.delete(teacherId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Search An Existing Teacher By Id
    @GetMapping("/{id}")
    public ResponseEntity<Teacher> getTeacherById(@PathVariable(value = "id") Long teacherId) {
        Teacher teacher = teacherService.getTeacherById(teacherId);
        return new ResponseEntity<>(teacher, HttpStatus.OK);
    }

    // Search An Existing Teacher By Name
    @GetMapping("/search/name")
    public List<Teacher> getTeacherByName(@RequestParam(value = "name") String teacherName) {
        return teacherService.getAllTeachersByName(teacherName);
    }

    // Search An Existing Teacher By Surname
    @GetMapping("/search/surname")
    public List<Teacher> getTeacherBySurname(@RequestParam(value = "surname") String teacherSurname) {
        return teacherService.getAllTeachersBySurname(teacherSurname);
    }

    // Search An Existing Teacher By DepartmentId
    @GetMapping("/search/departmentId")
    public List<Teacher> getTeacherByDepartmentId(@RequestParam(value = "departmentId") Long teacherDepartmentId){
        return teacherService.getAllTeachersByDepartmentId(teacherDepartmentId);
    }

}


