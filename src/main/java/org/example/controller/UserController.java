package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.model.user.RequestUpdateNameUser;
import org.example.model.user.UserRequest;
import org.example.model.user.UserResponse;
import org.example.repository.UserRepository;
import org.example.service.UserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("user")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
@Validated
public class UserController {
    private final UserService userService;
    private final UserRepository userRepository;

    @PostMapping("create")
    public UserResponse createUser(@RequestBody @Valid UserRequest userRequest){
        return userService.createUser(userRequest);
    }

    @GetMapping("find/{id}")
    public UserResponse findById(@PathVariable Integer id){
        return userService.findById(id);
    }

    @GetMapping
    public List<UserResponse> findAll(){
        return userService.findAll();
    }

    @PostMapping("update-user-name/{id}")
    public void updateUserName(@PathVariable Integer id, @RequestBody @Valid RequestUpdateNameUser requestUpdateNameUser){
        userService.updateUserName(id, requestUpdateNameUser);
    }


}
