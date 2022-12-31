package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.model.department.DepartmentRequest;
import org.example.model.department.DepartmentResponse;
import org.example.model.department.RequestUpdateDepartmentName;
import org.example.repository.DepartmentRepository;
import org.example.service.DepartmentService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("department")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
@Validated
public class DepartmentController {
    private final DepartmentService departmentService;

    private final DepartmentRepository departmentRepository;


    @PostMapping("create")
    public DepartmentResponse createDepartment(@RequestBody @Valid DepartmentRequest departmentRequest){
        return departmentService.createDepartment(departmentRequest);
    }

    @GetMapping("find/{id}")
    public DepartmentResponse findById(@PathVariable Integer id){
        return departmentService.findById(id);
    }

    @GetMapping
    public List<DepartmentResponse> findAll() {
        return departmentService.findAll();
    }

    @PostMapping("update-department-name/{id}")
    public void updateDepartmentName(@PathVariable Integer id, @RequestBody @Valid RequestUpdateDepartmentName requestUpdateDepartmentName) {
        departmentService.updateDepartmentName(id, requestUpdateDepartmentName);
    }
}
