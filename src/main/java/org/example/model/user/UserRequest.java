package org.example.model.user;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserRequest {
    private Integer id;

    @NotBlank(message = "Invalid user name")
    private String userName;

    @NotBlank
    private String userEmail;

    private Integer clientId;
    private int[] userClientsIds;

}
