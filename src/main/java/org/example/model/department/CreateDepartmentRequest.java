package org.example.model.department;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CreateDepartmentRequest {

    @NotBlank
    private String departmentName;

    private Integer client_id;
}
