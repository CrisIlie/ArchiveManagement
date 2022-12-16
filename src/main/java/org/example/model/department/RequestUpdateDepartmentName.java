package org.example.model.department;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class RequestUpdateDepartmentName {

    private Integer id;

    @NotBlank
    private String departmentName;
}
