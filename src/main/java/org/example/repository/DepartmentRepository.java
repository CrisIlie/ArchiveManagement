package org.example.repository;

import org.example.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<org.example.entity.Department, Integer> {
    List<Department> findAllByOrderByDepartmentName();

    List<Department> findAllByDepartmentName(Department name);
}
