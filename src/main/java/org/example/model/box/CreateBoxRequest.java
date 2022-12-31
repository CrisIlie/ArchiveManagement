package org.example.model.box;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;


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
    @NotNull
    private Date beginningDate;
    @NotNull
    private Date endDate;
    @NotNull
    private Integer storageTime;

}
