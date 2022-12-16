package org.example.model.emptyBox;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class EmptyBoxRequest {

    private Integer id;

    @NotBlank(message = "Invalid box type")
    private String boxType;

    @NotNull
    private Integer stock;
}

