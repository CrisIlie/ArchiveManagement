package org.example.model.client;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class RequestUpdateAddress {
    private Integer id;

    @NotBlank
    private String address;
}
