package org.example.model.user;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class RequestUpdateNameUser {
    private Integer id;

    @NotBlank
    private String userName;
}
