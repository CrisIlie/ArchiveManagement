package org.example.model.client;

import lombok.Data;
import org.example.model.box.BoxResponse;


import java.util.List;

@Data
public class ClientDetailResponse {
    private Integer id;
    private String clientName;
    private List<BoxResponse> boxes;
}
