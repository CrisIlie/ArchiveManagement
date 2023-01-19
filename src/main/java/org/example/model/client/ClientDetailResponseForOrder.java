package org.example.model.client;

import lombok.Data;
import org.example.model.Order.OrderResponseForClientDetail;

import java.util.List;


@Data
public class ClientDetailResponseForOrder {
    private String clientName;
    private List<OrderResponseForClientDetail> orders;
}
