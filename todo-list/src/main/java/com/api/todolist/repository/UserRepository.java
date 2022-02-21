package com.api.todolist.repository;

import com.api.todolist.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {

    public Optional<UserModel> findByLogin (String Login);
}
