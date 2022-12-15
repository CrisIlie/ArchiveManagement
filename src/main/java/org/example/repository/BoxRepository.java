package org.example.repository;

import org.example.entity.Box;
import org.example.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoxRepository extends JpaRepository<Box, Integer> {
    List<Box> findAllByOrderByDepartmentNameAsc();

    List<Box> findAllByDepartmentName(Department name);
}