package org.example.model.user;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CreateUserRequest {

    @NotBlank
    private String userName;

    @NotBlank
    private String userEmail;

}
