package org.example.model.client;

import lombok.Data;

@Data
public class ClientResponse {

    private Integer id;
    private String clientName;
    private String address;
    private String clientEmail;
}
