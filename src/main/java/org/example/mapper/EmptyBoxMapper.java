package org.example.mapper;

import org.example.entity.EmptyBox;
import org.example.model.emptyBox.EmptyBoxRequest;
import org.example.model.emptyBox.EmptyBoxResponse;
import org.example.model.emptyBox.RequestUpdateStock;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@ComponentScan
@Mapper(componentModel = "spring")
public interface EmptyBoxMapper {
    EmptyBox map(EmptyBoxRequest emptyBoxRequest);

    EmptyBoxResponse map(EmptyBox emptyBox);

    List<EmptyBoxResponse> map(List<EmptyBox> all);

    EmptyBox map(RequestUpdateStock requestUpdateStock);
}
