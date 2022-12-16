package org.example.repository;

import org.example.entity.Box;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoxRepository extends JpaRepository<Box, Integer> {
    List<Box> findAllByOrderByDepartmentNameAsc();

    List<Box> findAllByDepartmentName(@Param("departmentName") String departmentName);
}
