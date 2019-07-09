package com.example.kproject.repository;

import com.example.kproject.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    List<Teacher> getByName(String name);

    List<Teacher> getBySurname(String surname);

    List<Teacher> getAllTeachersByDepartmentId(Long groupId);
}
