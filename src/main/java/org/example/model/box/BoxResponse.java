package org.example.model.box;

import lombok.Data;

import java.sql.Date;


@Data
public class BoxResponse {

    private Integer id;
    private String boxType;
    private String clientBoxCode;
    private String clientName;
    private String departmentName;
    private String boxSummary;
    private String nomenclatureId;
    private Date beginningDate;
    private Date endDate;
    private Integer storageTime;
}
