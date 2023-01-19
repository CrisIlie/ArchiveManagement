package org.example.repository;

import org.example.entity.Box;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface BoxRepository extends JpaRepository<Box, Integer> {
    List<Box> findAllByOrderByDepartmentIdAsc();

    List<Box> findAllByDepartmentId(@Param("id") Integer id);

    List<Box> findAllByClientId(@Param("id") Integer id);

    @Query("Select t from Box t where t.clientBoxCode= :clientBoxCode")
    default String findByClientBoxCode(@Param("clientBoxCode") String clientBoxCode){
        return clientBoxCode;
    };
}
