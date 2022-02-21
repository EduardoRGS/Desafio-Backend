package com.api.todolist.service;

//import com.api.todolist.date.UserDate;
import lombok.AllArgsConstructor;
import com.api.todolist.model.UserModel;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.api.todolist.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserModel createUser (UserModel userModel){
        return userRepository.save(userModel);
    }

    public List<UserModel> listAllUsers(){
        return userRepository.findAll();
    }

   //
}
