package org.example.model.emptyBoxOrder;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class CreateEmptyBoxOrderRequest {
    @NotBlank
    private String boxType;

    @NotNull
    private Integer orderedAmount;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate orderDate;

    private Integer client_id;
}
