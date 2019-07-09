package com.example.kproject.service;

import com.example.kproject.exception.NoRecordFoundException;
import com.example.kproject.exception.NoRecordFoundToDelete;
import com.example.kproject.exception.NoRecordFoundToUpdate;
import com.example.kproject.model.Teacher;
import com.example.kproject.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public void create(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    @Override
    public void update(Teacher teacher) {
        Optional<Teacher> founded = teacherRepository.findById(teacher.getId());
        if (founded.isPresent()) {
            teacherRepository.save(teacher);
        } else {
            throw new NoRecordFoundToUpdate("There Is No Teacher With Id = " + teacher.getId());
        }
    }

    @Override
    public void delete(Long teacherId) {
        Optional founded = teacherRepository.findById(teacherId);
        if (founded.isPresent()) {
            teacherRepository.deleteById(teacherId);
        } else {
            throw new NoRecordFoundToDelete("There Is No Teacher With Id = " + teacherId);
        }
    }

    @Override
    public List<Teacher> getAllTeachers() {
        List<Teacher> teachers = teacherRepository.findAll();
        if (teachers == null || teachers.isEmpty()) {
            throw new NoRecordFoundException("No Teachers Have Been Created Yet");
        } else {
            return teachers;
        }
    }

    @Override
    public Teacher getTeacherById(Long id) {
        Optional optional = teacherRepository.findById(id);
        if (optional.isPresent()) {
            return (Teacher) optional.get();
        } else {
            throw new NoRecordFoundException("There Is No Teacher With Id = " + id);
        }
    }

    @Override
    public List<Teacher> getAllTeachersByName(String name) {
        List<Teacher> teachers = teacherRepository.getByName(name);
        if (teachers == null || teachers.isEmpty()) {
            throw new NoRecordFoundException("There Is No Teacher With Name = " + name);
        } else {
            return teachers;
        }
    }

    @Override
    public List<Teacher> getAllTeachersBySurname(String surname) {
        List<Teacher> teachers = teacherRepository.getBySurname(surname);
        if (teachers == null || teachers.isEmpty()) {
            throw new NoRecordFoundException("There Is No Teacher With Surname = " + surname);
        } else {
            return teachers;
        }
    }

    @Override
    public List<Teacher> getAllTeachersByDepartmentId(Long departmentId) {
        List<Teacher> teachers = teacherRepository.getAllTeachersByDepartmentId(departmentId);
        if (teachers == null || teachers.isEmpty()) {
            throw new NoRecordFoundException("There Is No Teacher In Department = " + departmentId);
        } else {
            return teachers;
        }
    }
}