package com.api.todolist.controller;

import com.api.todolist.model.UserModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import com.api.todolist.service.UserService;

import java.util.List;

@RestController
@RequestMapping("api/user")
@AllArgsConstructor
@Slf4j
public class UserController {

     UserService userService;
     PasswordEncoder encoder;

    @ApiOperation(value = "Criando um novo usuário(a)")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Usuário(a) criado(a) com sucesso"),
            @ApiResponse(code = 500, message = "Houve um erro ao criar um usuário(a), verifique as informações")
    })
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public UserModel createUser (@RequestBody UserModel userModel){
        userModel.setPassword(encoder.encode(userModel.getPassword()));
        log.info("Criando um novo usuário(a) com as informações [{}]", userModel);
        return userService.createUser(userModel);
    }

    @ApiOperation(value = "Listando todos os usuários(as)")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Usuários(as) listados com sucesso"),
            @ApiResponse(code = 500, message = "Houve um erro ao lista os usuários")
    })
    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public List<UserModel> getAllUsers (){
        log.info("Listando todas os usuários(as) cadastrados");
        return userService.listAllUsers();
    }

}
