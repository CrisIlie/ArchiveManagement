package org.example.repository;

import org.example.entity.Client;
import org.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<org.example.entity.User, Integer> {
    List<User> findAllByOrderByUserName();

    List<User> findAllByClientName(Client name);
}
