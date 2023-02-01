package org.example.model.emptyBox;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmptyBoxRequest {

    private Integer id;

    @NotBlank(message = "Invalid box type")
    private String boxType;

    @NotNull
    @Positive
    private Integer stock;

}

