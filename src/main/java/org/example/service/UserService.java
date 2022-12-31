package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.entity.User;
import org.example.exception.BusinessException;
import org.example.mapper.UserMapper;
import org.example.model.user.RequestUpdateNameUser;
import org.example.model.user.UserRequest;
import org.example.model.user.UserResponse;
import org.example.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public UserResponse createUser(UserRequest userRequest){
        checkDuplicate(userRequest);
        User user = userMapper.map(userRequest);
        return userMapper.map(userRepository.save(user));
    }

    private void checkDuplicate(UserRequest userRequest) {
        for (User user : userRepository.findAll()){
            if(user.getUserName().equalsIgnoreCase(userRequest.getUserName())){
                throw new BusinessException("This user name is already used. Choose another name!");
            }
        }
    }

    public List<UserResponse> findAll(){
        return userMapper.map(userRepository.findAll());
    }

    public UserResponse findById(Integer id){
        return userMapper.map(userRepository.findById(id).orElseThrow(
                ()-> new BusinessException("User id not found")
        ));
    }

    public void updateUserName(Integer id, RequestUpdateNameUser requestUpdateNameUser){
        User userNameToUpdate = userRepository.findById(id).orElseThrow(
                ()-> new BusinessException(String.format("User with id: %s not found", id))
        );
    }
}
