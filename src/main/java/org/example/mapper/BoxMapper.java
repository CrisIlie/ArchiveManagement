package org.example.mapper;

import org.example.entity.Box;
import org.example.model.box.*;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@ComponentScan
@Mapper
public interface BoxMapper {

    Box map(BoxRequest boxRequest);

    BoxResponse map(Box box);

    List<BoxResponse> map(List<Box> all);

}
