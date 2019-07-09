package com.example.kproject.service;

import com.example.kproject.exception.NoRecordFoundException;
import com.example.kproject.exception.NoRecordFoundForeignKey;
import com.example.kproject.exception.NoRecordFoundToDelete;
import com.example.kproject.exception.NoRecordFoundToUpdate;
import com.example.kproject.model.Student;
import com.example.kproject.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        if (students == null || students.isEmpty()) {
            throw new NoRecordFoundException("No Students Have Been Created Yet");
        } else {
            return students;
        }
    }

    @Override
    public void create(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void update(Student student) {
        Optional<Student> founded = studentRepository.findById(student.getId());
        if (founded.isPresent()) {
            studentRepository.save(student);
        } else {
            throw new NoRecordFoundToUpdate("There Is No Student With Id = " + student.getId());
        }

    }

    @Override
    public void delete(Long studentId) {
        Optional founded = studentRepository.findById(studentId);
        if (founded.isPresent()) {
            studentRepository.deleteById(studentId);
        } else {
            throw new NoRecordFoundToDelete("There Is No Student With Id = " + studentId);
        }

    }

    @Override
    public Student getById(Long id) {
        Optional optional = studentRepository.findById(id);
        if (optional.isPresent()) {
            return (Student) optional.get();
        } else {
            throw new NoRecordFoundException("There Is No Student With Id = " + id);
        }
    }

    @Override
    public List<Student> getByName(String name) {
        List<Student> students = studentRepository.getByName(name);
        if (students == null || students.isEmpty()) {
            throw new NoRecordFoundException("There Is No Student With Name = " + name);
        } else {
            return students;
        }
    }

    @Override
    public List<Student> getBySurname(String surname) {
        List<Student> students = studentRepository.getBySurname(surname);
        if (students == null || students.isEmpty()) {
            throw new NoRecordFoundException("There Is No Student With Surname = " + surname);
        } else {
            return students;
        }
    }

    @Override
    public List<Student> getStudentByGroupId(Long groupId) {
        List<Student> students = studentRepository.getByGroupId(groupId);
        if (students == null || students.isEmpty()) {
            throw new NoRecordFoundForeignKey("There Is No Group With Id = " + groupId);
        } else {
            return students;
        }
    }
}
