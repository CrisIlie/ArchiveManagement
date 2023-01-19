package org.example.model.box;

import lombok.Data;
import org.example.entity.statusEnum.BoxStatusEnum;

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
    private Integer department_id;
    private Integer client_id;
    private Integer order_id;
}
