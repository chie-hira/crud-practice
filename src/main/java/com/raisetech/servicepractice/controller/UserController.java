package com.raisetech.servicepractice.controller;

import com.raisetech.servicepractice.entity.User;
import com.raisetech.servicepractice.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable("id") int id ){
        return userService.findUser(id);
    }

    @PostMapping("/users")
    public ResponseEntity<UserResponse> insert(@RequestBody UserRequest userRequest, UriComponentsBuilder uriBuilder){
        User user = userService.insert(userRequest.getName(), userRequest.getEmail());
        URI location = uriBuilder.path("/users/{id}").buildAndExpand(user.getId()).toUri();
        UserResponse body = new UserResponse("user created");
        return ResponseEntity.created(location).body(body);
    }

}
