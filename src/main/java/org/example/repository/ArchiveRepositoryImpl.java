package org.example.repository;

import lombok.RequiredArgsConstructor;
import org.example.entity.*;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ArchiveRepositoryImpl {

    private final EntityManager entityManager;

    public List<Client> findAllByClientName(String clientName){
        return entityManager.createQuery(
                "SELECT t from Client t where t.clientName=:clientName", Client.class)
                .setParameter("clientName", clientName)
                .getResultList();
    }

    public List<Box> findAllByDepartmentName(String departmentName){
        return entityManager.createQuery(
                "SELECT t from Box t where t.departmentName=:departmentName", Box.class)
                .setParameter("departmentName", departmentName)
                .getResultList();
    }


}
