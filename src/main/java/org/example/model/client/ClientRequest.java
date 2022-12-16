package org.example.model.client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientRequest {

    private Integer id;

    @NotBlank(message = "Invalid client name")
    private String clientName;

    @NotBlank
    private String address;

    @NotBlank
    private String clientEmail;

    private Boolean active;


}
