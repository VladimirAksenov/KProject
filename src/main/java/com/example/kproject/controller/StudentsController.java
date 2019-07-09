package com.example.kproject.controller;

import com.example.kproject.model.Student;
import com.example.kproject.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentsController {

    private final StudentService studentService;

    public StudentsController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Get All Students
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    // Create New Student
    @PostMapping
    public void createStudent(@Valid @RequestBody Student student) {
        studentService.create(student);
    }

    // Update An Existing Student
    @PutMapping
    public void updateStudent(@Valid @RequestBody Student studentDetails) {
        studentService.update(studentDetails);
    }

    // Delete An Existing Student
    @DeleteMapping("/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable(value = "id") Long studentId) {
        studentService.delete(studentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Search An Existing Student By Id
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable(value = "id") Long studentId) {
        Student student = studentService.getById(studentId);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    // Search An Existing Student By Name
    @GetMapping("/search/name")
    public List<Student> getStudentTByName(@RequestParam(value = "name") String studentName) {
        return studentService.getByName(studentName);
    }

    // Search An Existing Student By Surname
    @GetMapping("/search/surname")
    public List<Student> getStudentBySurname(@RequestParam(value = "surname") String studentSurname) {
        return studentService.getBySurname(studentSurname);
    }

    // Search An Existing Student By GroupId
    @GetMapping("/search/groupId")
    public List<Student> getStudentByGroupId(@RequestParam(value = "groupId") Long groupId) {
        return studentService.getStudentByGroupId(groupId);
    }
}
