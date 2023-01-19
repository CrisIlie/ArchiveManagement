package org.example.model.department;

import lombok.Data;

@Data
public class DepartmentResponse {

    private Integer id;
    private String departmentName;
    private Integer client_id;
}
