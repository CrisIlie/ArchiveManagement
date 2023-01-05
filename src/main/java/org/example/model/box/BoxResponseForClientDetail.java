package org.example.model.box;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


import java.util.Date;
import java.util.List;


@Getter
@Setter
@Data
public class BoxResponseForClientDetail {
    private String boxType;
    private String clientBoxCode;
    private String departmentName;
    private String boxSummary;
    private String nomenclatureId;
    private Date beginningDate;
    private Date endDate;
    private Integer storageTime;


}
