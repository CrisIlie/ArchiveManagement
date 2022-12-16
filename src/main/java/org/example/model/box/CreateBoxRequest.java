package org.example.model.box;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.sql.Date;

@Data
public class CreateBoxRequest {
    @NotBlank
    private String boxType;
    @NotBlank
    private String clientBoxCode;
    @NotBlank
    private String clientName;
    @NotBlank
    private String departmentName;
    @NotBlank
    private String boxSummary;
    @NotBlank
    private String nomenclatureId;
    @NotBlank
    private Date beginningDate;
    @NotBlank
    private Date endDate;
    @NotBlank
    private Integer storageTime;

    private Integer departmentId;
    private int[] boxDepartmentsIds;
}
