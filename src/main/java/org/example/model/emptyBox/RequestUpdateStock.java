package org.example.model.emptyBox;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class RequestUpdateStock {
    private Integer id;

    @NotNull
    @Positive
    private Integer stock;
}
