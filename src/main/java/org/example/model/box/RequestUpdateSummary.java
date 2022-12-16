package org.example.model.box;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class RequestUpdateSummary {

    private Integer id;

    @NotBlank
    private String boxSummary;
}
