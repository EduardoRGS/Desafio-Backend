package com.api.todolist.controller;

import com.api.todolist.model.UserModel;
import com.api.todolist.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import com.api.todolist.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/usuario")
@AllArgsConstructor
@Slf4j
public class UserController {

     UserService userService;
     UserRepository userRepository;
    PasswordEncoder encoder;


    @PostMapping("/cadastrar")
    public UserModel createUser (@RequestBody UserModel userModel){
        userModel.setPassword(encoder.encode(userModel.getPassword()));
        return userService.createUser(userModel);
    }

    @GetMapping("/users")
    public List<UserModel> getAllUsers (){
        return userService.listAllUsers();
    }

    //
}
