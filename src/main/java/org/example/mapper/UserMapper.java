package org.example.mapper;

import org.example.entity.User;
import org.example.model.user.RequestUpdateNameUser;
import org.example.model.user.UserRequest;
import org.example.model.user.UserResponse;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@ComponentScan
@Mapper(componentModel = "spring")
public interface UserMapper {
    User map(UserRequest userRequest);

    UserResponse map(User user);

    List<UserResponse> map(List<User> allUsers);

    User map(RequestUpdateNameUser requestUpdateNameUser);
}
