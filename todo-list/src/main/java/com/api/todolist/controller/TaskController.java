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
@RequestMapping("api/")
@Slf4j
public class TaskController {

    TaskService taskService;

    @PostMapping("tasks/create")
    public TaskModel createTask (@RequestBody TaskModel taskModel){
        return taskService.createTask(taskModel);
    }

    @GetMapping("tasks")
    public List<TaskModel> getAllTasks(){
        return taskService.listAllTasks();
    }

    @GetMapping("tasks/pendings")
    public List<TaskModel> getAllTasksPending(){
        return taskService.listTasksPending();
    }

    @PutMapping("tasks/update/{id}")
    public ResponseEntity<TaskModel> updateTaskById (@PathVariable (value = "id") Long id,
                                                     @RequestBody TaskModel taskModel){
        return taskService.updateTaskById(taskModel,id);
    }

    @PatchMapping("tasks/updateDone/{id}")
    public ResponseEntity<TaskModel> updateTaskDone (@PathVariable ( value = "id") Long id){
        return taskService.updateTaskcompleted(id);
    }

    @DeleteMapping("tasks/{id}")
    public ResponseEntity<Object> deleteTaskById (@PathVariable (value = "id") Long id){
        return taskService.deleteById(id);
    }
}
