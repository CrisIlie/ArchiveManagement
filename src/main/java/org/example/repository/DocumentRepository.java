package org.example.repository;

import org.example.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DocumentRepository extends JpaRepository<Document, Integer> {
    List<Document> findAllByOrderByClientBoxCode();

    List<Document> findAllByClientBoxCode(@Param("clientBoxCode") String clientBoxCode);
}
