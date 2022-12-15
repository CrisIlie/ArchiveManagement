package org.example.repository;

import org.example.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientRepository extends JpaRepository<org.example.entity.Client, Integer> {

    List<Client> findAllByOrderByClientName();

    List<Client> findAllByClientName(@Param("clientName") String clientName);
}
