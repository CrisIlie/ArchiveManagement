package org.example.model.box;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class RequestUpdateBoxType {

    private Integer id;

    @NotBlank
    private String boxType;
}
