package org.example.mapper;

import org.example.entity.Order;
import org.example.model.Order.OrderRequest;
import org.example.model.Order.OrderResponse;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@ComponentScan
@Mapper(componentModel = "spring")
public interface OrderMapper {

    Order map(OrderRequest orderRequest);

    OrderResponse map(Order boxOrder);

    List<OrderResponse> map(List<Order> allOrders);


}
