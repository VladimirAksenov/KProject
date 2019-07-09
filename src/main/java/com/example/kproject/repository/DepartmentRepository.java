package com.example.kproject.repository;

import com.example.kproject.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    List<Department> getAllByName(String name);

    List<Department> getAllByFloor(Long id);
}
