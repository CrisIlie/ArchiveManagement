package org.example.model.department;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentRequest {

    private Integer id;

    @NotBlank(message = "Invalid department name")
    private String departmentName;

    private Integer clientId;
    private int[] departmentClientsIds;

}
