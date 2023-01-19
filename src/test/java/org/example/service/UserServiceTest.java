package org.example.service;

import org.example.entity.User;
import org.example.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class UserServiceTest {

    @Test
    void createUser() {
        UserRepository userRepository = Mockito.mock(UserRepository.class);
        UserService userService = new UserService(userRepository);
        User user = new User();
        user.setUserName("Ilinca");
        user.setUserEmail("arcvhive.management@gmail.com");
        user.setPassword("abcd");
        userService.createUser(user);
        System.out.println(userService.getAll());
    }
}
