package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.entity.Department;
import org.example.exception.BusinessException;
import org.example.mapper.DepartmentMapper;
import org.example.model.department.DepartmentRequest;
import org.example.model.department.DepartmentResponse;
import org.example.model.department.RequestUpdateDepartmentName;
import org.example.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    private final DepartmentMapper departmentMapper;

    public DepartmentResponse createDepartment(DepartmentRequest departmentRequest) {
        checkDuplicate(departmentRequest);
        Department department = departmentMapper.map(departmentRequest);
        return departmentMapper.map(departmentRepository.save(department));
    }

    private void checkDuplicate(DepartmentRequest departmentRequest) {
        for (Department department : departmentRepository.findAll()) {
            if (department.getDepartmentName().equalsIgnoreCase(department.getDepartmentName())) {
                throw new BusinessException("This department already exists");
            }
        }
    }

    public List<DepartmentResponse> findAll() {
        return departmentMapper.map(departmentRepository.findAll());
    }

    public DepartmentResponse findById(Integer id) {
        return departmentMapper.map(departmentRepository.findById(id).orElseThrow(
                () -> new BusinessException("Department not found")
        ));
    }

    public void updateDepartmentName(Integer id, RequestUpdateDepartmentName requestUpdateDepartmentName) {
        Department departmentNameToUpdate = departmentRepository.findById(id).orElseThrow(
                () -> new BusinessException(String.format("Department with id: %s not found", id))
        );
        departmentNameToUpdate.setDepartmentName(requestUpdateDepartmentName.getDepartmentName());
    }


}
