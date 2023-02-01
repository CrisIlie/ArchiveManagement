package org.example.model.department;

import lombok.Data;
import org.example.model.client.ClientResponseForDepartment;

@Data
public class DepartmentResponse {

    private Integer id;
    private String departmentName;
    private ClientResponseForDepartment client;
}
