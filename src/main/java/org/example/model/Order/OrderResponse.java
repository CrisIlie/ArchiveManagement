package org.example.model.Order;

import lombok.Data;
import org.example.entity.Client;
import org.example.model.box.BoxResponse;
import org.example.model.client.ClientDetailResponseForOrder;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
public class OrderResponse {

    private Integer id;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDate boxOrderDate;

    private Boolean delivered;
    private ClientDetailResponseForOrder client;
    private final Set<BoxResponse> orderedBoxes = new HashSet<>();
}
