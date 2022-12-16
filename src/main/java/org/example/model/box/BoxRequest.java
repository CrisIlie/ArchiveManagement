package org.example.model.box;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.sql.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoxRequest {

    private Integer id;

    @NotBlank(message = "Invalid box type")
    private String boxType;

    @NotBlank(message = "Invalid box code")
    private String clientBoxCode;

    @NotBlank(message = "Invalid client name")
    private String clientName;

    @NotBlank(message = "Invalid department name")
    private Integer departmentName;

    @NotBlank
    private String boxSummary;

    @NotBlank
    private String nomenclatureId;

    @Past
    private Date beginningDate;

    @Past
    private Date endDate;

    @NotBlank(message = "Storage time must be a number (number of years)")
    private Integer storageTime;

    private Integer departmentId;
    private int[] boxDepartmentsIds;
}
