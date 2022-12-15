package org.example.repository;

import org.example.entity.Client;
import org.example.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<org.example.entity.Department, Integer> {
    List<Department> findAllByOrderByDepartmentName();

    List<Department> findAllByClient(@Param("clientName") String clientName);
}
