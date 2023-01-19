package org.example.model.Order;

import lombok.Data;
import org.example.model.box.BoxResponse;
import org.example.model.box.BoxResponseForClientDetail;

import java.time.LocalDate;
import java.util.List;

@Data
public class OrderResponseForClientDetail {
    private Integer id;
    private LocalDate boxOrderDate;
    private Boolean delivered;
    List<BoxResponseForClientDetail> orderedBoxes;
}
