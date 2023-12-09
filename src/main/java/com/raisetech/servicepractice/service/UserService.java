package com.raisetech.servicepractice.service;

import com.raisetech.servicepractice.exception.UserAlreadyExistsException;
import com.raisetech.servicepractice.exception.UserNotFoundException;
import com.raisetech.servicepractice.entity.User;
import com.raisetech.servicepractice.mapper.UserMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserMapper userMapper;

    public UserService(UserMapper userMapper){
        this.userMapper = userMapper;
    }

    public List<User> findAll(){return this.userMapper.findAll();}

    public User findUser(int id){
        Optional<User> user = this.userMapper.findById(id);
        return user.orElseThrow(()-> new UserNotFoundException("user not found", HttpStatus.NOT_FOUND));
    }

    public User insert(String name, String email) {
        Optional<User> userOptional = this.userMapper.findByEmail(email);
        if (userOptional.isPresent()){
            throw new UserAlreadyExistsException("email:" + email + "already exists");
        }
        User user = new User(name, email);
        userMapper.insert(user);
        return user;
    }
}
