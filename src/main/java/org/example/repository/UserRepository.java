package org.example.repository;


import org.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT u from User u WHERE u.userEmail = ?1")
    User findByUserEmail(String userEmail);
}
