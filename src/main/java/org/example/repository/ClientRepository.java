package org.example.repository;

import org.example.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<org.example.entity.Client, Integer> {

    List<Client> findAllByOrderByClientName();

    List<Client> findAllByClientName(Client name);
}
