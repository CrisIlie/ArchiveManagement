package org.example.model.emptyBox;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class RequestUpdateStock {
    private Integer id;

    @NotNull
    private Integer stock;
}
