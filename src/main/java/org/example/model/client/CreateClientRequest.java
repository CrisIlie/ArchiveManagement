package org.example.model.client;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CreateClientRequest {

    @NotBlank
    private String clientName;

    @NotBlank
    private String address;

    @NotBlank
    private String email;
}
