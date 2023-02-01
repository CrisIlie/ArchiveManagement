package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.entity.Client;
import org.example.entity.Department;
import org.example.exception.BusinessException;
import org.example.mapper.DepartmentMapper;
import org.example.model.department.DepartmentRequest;
import org.example.model.department.DepartmentResponse;
import org.example.model.department.RequestUpdateDepartmentName;
import org.example.repository.ClientRepository;
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
    private final ClientRepository clientRepository;

    public DepartmentResponse createDepartment(DepartmentRequest departmentRequest) {
        for (Department department : departmentRepository.findAll()) {
            if (department.getDepartmentName().equalsIgnoreCase(departmentRequest.getDepartmentName())) {
                throw new BusinessException("This department already exists");
            }
        }
        Department departmentToSave = departmentMapper.map(departmentRequest);

        Client client = clientRepository.findById(departmentRequest.getClientId()).orElseThrow(() -> new BusinessException("Client not found"));
        departmentToSave.setClient(client);

        return departmentMapper.map(departmentRepository.save(departmentToSave));
    }

    public List<DepartmentResponse> getAllDepartments() {
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

    public void updateDepartment(DepartmentRequest departmentRequest) {
        for (Department department : departmentRepository.findAll()) {
            if (department.getDepartmentName().equalsIgnoreCase(departmentRequest.getDepartmentName())) {
                throw new BusinessException("This department already exists");
            }
        }
        Department departmentToUpdate = departmentRepository.findById(departmentRequest.getId()).orElseThrow(() -> new BusinessException("Department not found"));
        departmentToUpdate.setDepartmentName(departmentRequest.getDepartmentName());
        departmentToUpdate.setClient(clientRepository.getReferenceById(departmentToUpdate.getId()));
    }

    public void deleteById(Integer id) {
        Department departmentToDelete = departmentRepository.findById(id).orElseThrow(
                () -> new BusinessException("Department not found")
        );
        departmentRepository.deleteById(departmentToDelete.getId());
    }

}
