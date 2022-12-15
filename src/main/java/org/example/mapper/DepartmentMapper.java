package org.example.mapper;

import org.example.entity.Department;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@ComponentScan
@Mapper(componentModel = "spring")
public interface DepartmentMapper {
    Department map(DepartmentRequest departmentRequest);

    DepartmentResponse map(Department department);

    List<DepartmentResponse> map(List<Department> allDepartments);

    Department map(RequestUpdateDepartmentName requestUpdateDepartmentName);

}
