package org.example.model.emptyBox;

import lombok.Data;

@Data
public class EmptyBoxResponse {
    private Integer id;
    private String boxType;
    private Integer stock;
    private Integer orderedAmount;
}
