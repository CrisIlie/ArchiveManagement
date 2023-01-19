package org.example.repository;

import org.example.entity.EmptyBoxOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmptyBoxOrderRepository extends JpaRepository<EmptyBoxOrder, Integer> {
    List<EmptyBoxOrder> findAllByOrderByClientIdAsc();

    List<EmptyBoxOrder> findAllByClientId(@Param("id") Integer id);

    @Query("Select t from EmptyBoxOrder t where t.boxType= :boxType")
    default String findByBoxType(@Param("boxType") String boxType){
        return boxType;
    };

}
