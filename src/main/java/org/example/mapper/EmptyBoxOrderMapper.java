package org.example.mapper;

import org.example.entity.EmptyBoxOrder;

import org.example.model.emptyBoxOrder.EmptyBoxOrderRequest;
import org.example.model.emptyBoxOrder.EmptyBoxOrderResponse;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@ComponentScan
@Mapper(componentModel = "spring")
public interface EmptyBoxOrderMapper {

    EmptyBoxOrder map(EmptyBoxOrderRequest emptyBoxRequest);

    EmptyBoxOrderResponse map(EmptyBoxOrder emptyBoxOrder);

    List<EmptyBoxOrderResponse> map(List<EmptyBoxOrder> all);

}
