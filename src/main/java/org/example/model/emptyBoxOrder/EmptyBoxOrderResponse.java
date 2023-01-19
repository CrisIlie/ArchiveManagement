package org.example.model.emptyBoxOrder;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EmptyBoxOrderResponse {
    private Integer id;
    private String boxType;
    private Integer orderedAmount;
    private LocalDate orderDate;
    private Integer client_id;

}
