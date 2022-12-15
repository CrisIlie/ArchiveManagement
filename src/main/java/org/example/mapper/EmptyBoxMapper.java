package org.example.mapper;

import org.example.entity.EmptyBox;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@Mapper(componentModel = "spring")
public interface EmptyBoxMapper {
    EmptyBox map(EmptyBoxRequest emptyBoxRequest);

    EmptyBoxResponse map(EmptyBox emptyBox);

    List<EmptyBoxResponse> map(List<EmptyBox> allEmptyBoxes);

    EmptyBox map(RequestUpdateStock requestUpdateStock);
}
