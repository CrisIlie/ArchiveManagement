package org.example.repository;


import org.example.entity.EmptyBox;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmptyBoxRepository extends JpaRepository<org.example.entity.EmptyBox, Integer> {

    List<EmptyBox> findAllByEmptyBoxBoxType();
}
