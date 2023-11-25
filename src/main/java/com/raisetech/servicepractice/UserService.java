package com.raisetech.servicepractice;

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
//        return user.get(); // Optionalのget()はnullで例外を発生させる
        if (user.isPresent()){
            return user.get();
        } else {
            throw  new UserNotFoundException("user not found");
        }
    }
}
