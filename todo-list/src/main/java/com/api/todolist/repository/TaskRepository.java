package com.api.todolist.repository;

import com.api.todolist.enums.StatusEnum;
import com.api.todolist.model.TaskModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<TaskModel, Long> {

    @Query(value = "SELECT * FROM tasks T WHERE T.STATUS = 'PENDENTE'", nativeQuery = true)
    List<TaskModel> findByStatus(StatusEnum statusEnum);
}
