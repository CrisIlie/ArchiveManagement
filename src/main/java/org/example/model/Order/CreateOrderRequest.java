package org.example.model.Order;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;

@Data
public class CreateOrderRequest {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate boxOrderDate;

    private Boolean delivered;

    private Integer client_id;
    private List<Integer> orderedBoxesIds;
}
