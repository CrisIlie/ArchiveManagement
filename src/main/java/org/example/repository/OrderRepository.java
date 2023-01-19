package org.example.repository;


import org.example.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    List<Order> findAllByClientId(@Param("id") Integer id);

    @Query("Select t from Order t where t.boxOrderDate= :boxOrderDate")
  default LocalDate findByBoxOrderDate(@Param("boxOrderDate") LocalDate boxOrderDate){
        return boxOrderDate;
    };

}
