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

    public List<Department> findAllByClient(String clientName){
        return entityManager.createQuery(
                "SELECT t from Department t where t.client=:clientName", Department.class)
                .setParameter("clientName", clientName)
                .getResultList();
    }

    public List<User> findAllUsersByClient(String name){
        return entityManager.createQuery(
                "SELECT t from User t where t.client=:name", User.class)
                .setParameter("name", name)
                .getResultList();
    }

    public List<EmptyBox> findAllByBoxType(String boxType){
        return entityManager.createQuery(
                "SELECT t from EmptyBox t where t.boxType=:boxType")
                .setParameter("boxType", boxType)
                .getResultList();
    }
}
