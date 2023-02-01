package org.example.model.box;

import lombok.Data;
import org.example.entity.statusEnum.BoxStatusEnum;
import org.example.model.client.ClientResponseForBox;
import org.example.model.department.DepartmentResponseForBox;

import java.time.LocalDate;


@Data
public class BoxResponse {

    private Integer id;
    private String boxType;
    private String clientBoxCode;
    private BoxStatusEnum status;
    private String boxSummary;
    private String nomenclatureId;
    private LocalDate beginningDate;
    private LocalDate endDate;
    private Integer storageTime;
    private DepartmentResponseForBox department;
    private ClientResponseForBox client;

}
