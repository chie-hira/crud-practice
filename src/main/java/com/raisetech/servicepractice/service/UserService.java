package com.raisetech.servicepractice.service;

import com.raisetech.servicepractice.exception.UserNotFoundException;
import com.raisetech.servicepractice.entity.User;
import com.raisetech.servicepractice.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserMapper userMapper;

    public UserService(UserMapper userMapper){
        this.userMapper = userMapper;
    }

    public User findUser(int id){
        Optional<User> user = this.userMapper.findById(id);
        return user.orElseThrow(()-> new UserNotFoundException("user not found"));
    }

    public User insert(String name, String email) {
        User user = new User(name, email);
        userMapper.insert(user);
        return user;
    }
}
