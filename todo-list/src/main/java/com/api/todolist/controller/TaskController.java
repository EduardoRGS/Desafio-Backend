package com.api.todolist.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.api.todolist.model.TaskModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.api.todolist.service.TaskService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/usuario/task")
@Slf4j
public class TaskController {

    TaskService taskService;

    @PostMapping
    public TaskModel createTask (@RequestBody TaskModel taskModel){
        return taskService.createTask(taskModel);
    }

    @GetMapping
    public List<TaskModel> getAllTasks(){
        return taskService.listAllTasks();
    }

    @PutMapping
    public ResponseEntity<TaskModel> updateTaskById (@PathVariable (value = "id") Long id,
                                                     @RequestBody TaskModel taskModel){
        return taskService.updateTaskById(taskModel,id);
    }

    //Colocar um @PetMappinng para mudar o status do tarefa ou
    // mudar a prioridade

    @DeleteMapping
    public ResponseEntity<Object> deleteTaskById (@PathVariable (value = "id") Long id){
        return taskService.deleteById(id);
    }
}
