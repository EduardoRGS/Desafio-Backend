package com.api.todolist.service;

import com.api.todolist.enums.StatusEnum;
import lombok.AllArgsConstructor;
import com.api.todolist.model.TaskModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.api.todolist.repository.TaskRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {

    private TaskRepository taskRepository;

    public TaskModel createTask (TaskModel taskModel){
        return taskRepository.save(taskModel);
    }

    public List<TaskModel> listAllTasks(){
        return taskRepository.findAll();
    }

    public List<TaskModel> listTasksPending() {
        return taskRepository.findByStatus(StatusEnum.PENDENTE);
    }

    public ResponseEntity<TaskModel> updateTaskById (TaskModel taskModel, Long id){
        return taskRepository.findById(id)
                .map(taskModelToUpdate -> {
                    taskModelToUpdate.setDescripton(taskModel.getDescripton());
                    taskModelToUpdate.setProperty(taskModel.getProperty());
                    taskModelToUpdate.setStatus(taskModel.getStatus());
                    TaskModel update = taskRepository.save(taskModelToUpdate);
                    return ResponseEntity.ok().body(update);
                }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<TaskModel> updateTaskcompleted (Long id) {
        return taskRepository.findById(id)
                .map(taskDone -> {
                    taskDone.setStatus(StatusEnum.CONCLUIDA);
                    TaskModel update = taskRepository.save(taskDone);
                    return ResponseEntity.ok().body(update);
                }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Object> deleteById (Long id){
        return taskRepository.findById(id)
                .map(taskModelToDelete -> {
                    taskRepository.deleteById(id);
                    return ResponseEntity.noContent().build();
                }).orElse(ResponseEntity.notFound().build());
    }


}
