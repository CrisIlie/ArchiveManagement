package org.example.repository;

import org.example.entity.BoxInterrogation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoxConsultation extends JpaRepository<BoxInterrogation, Integer> {

    List<BoxConsultation> findAllByClientName(@Param("clientName") String clientName);
}

