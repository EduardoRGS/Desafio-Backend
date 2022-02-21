package com.api.todolist.controller;

import com.api.todolist.model.EnumProperty;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.api.todolist.model.UserModel;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import com.api.todolist.service.UserService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/usuario")
@Slf4j
public class UserController {

    UserService userService;
    PasswordEncoder encoder;

    @PostMapping("cadastrar")
    public UserModel createUser (@RequestBody UserModel userModel){
        userModel.setPassword(encoder.encode(userModel.getPassword()));
        return userService.createUser(userModel);
    }

    @GetMapping("users")
    public List<UserModel> getAllUsers (){
        return userService.listAllUsers();
    }
}
