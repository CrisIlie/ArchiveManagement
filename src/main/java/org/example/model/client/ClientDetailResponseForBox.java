package org.example.model.client;

import lombok.Data;
import org.example.model.box.BoxResponse;
import org.example.model.box.BoxResponseForClientDetail;


import java.util.List;

@Data
public class ClientDetailResponseForBox {
    private String clientName;
    private List<BoxResponseForClientDetail> boxes;
}
