package org.example.model.emptyBox;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class CreateEmptyBoxRequest {

    @NotBlank
    private String boxType;

    @NotNull
    private Integer stock;

    @NotNull
    private Integer orderedAmount;
}
