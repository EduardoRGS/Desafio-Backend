package com.api.todolist.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.api.todolist.model.TaskModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.api.todolist.service.TaskService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/tasks")
@Slf4j
public class TaskController {

    TaskService taskService;

    @ApiOperation(value = "Criando uma nova tarefa")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Tarefa criada com sucesso"),
            @ApiResponse(code = 500, message = "Houve um erro ao criar a tarefa, verifique as informações")
    })
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public TaskModel createTask (@RequestBody TaskModel taskModel){
        log.info("Criando uma nova tarefa com as informações [{}]", taskModel);
        return taskService.createTask(taskModel);
    }

    @ApiOperation(value = "Listando todas as tarefas")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Tarefas listadas com sucesso"),
            @ApiResponse(code = 500, message = "Houve um erro ao lista as tarefas")
    })
    @GetMapping("/alltasks")
    @ResponseStatus(HttpStatus.OK)
    public List<TaskModel> getAllTasks(){
        log.info("Listando todas as tarefas cadastradas");
        return taskService.listAllTasks();
    }

    @ApiOperation(value = "Listando todas as pendentes")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Tarefas pendentes listadas com sucesso"),
            @ApiResponse(code = 500, message = "Houve um erro ao lista as tarefas pendentes")
    })
    @GetMapping("/pendings")
    @ResponseStatus(HttpStatus.OK)
    public List<TaskModel> getAllTasksPending(){
        log.info("Listando todas as tarefas pendentes cadastradas");
        return taskService.listTasksPending();
    }

    @ApiOperation(value = "Atualizando as informações da tarefa")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Tarefa atualizada com sucesso"),
            @ApiResponse(code = 404 , message = "Não foi possivel atualizar a tarefa - tarefa não encontrada")
    })
    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<TaskModel> updateTaskById (@PathVariable (value = "id") Long id,
                                                     @RequestBody TaskModel taskModel){
        log.info("Atualizando a tarefa com id [{}] as novas informações são: [{}]", id, taskModel);
        return taskService.updateTaskById(taskModel,id);
    }

    @ApiOperation(value = "Atualizando a tarefa como concluida")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Tarefa atualizada com sucesso"),
            @ApiResponse(code = 404 , message = "Não foi possivel atualizar a tarefa - tarefa não encontrada")
    })
    @PatchMapping("/updateDone/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<TaskModel> updateTaskDone (@PathVariable ( value = "id") Long id){
        log.info("Atualizando a tarefa com id [{}]", id);
        return taskService.updateTaskcompleted(id);
    }

    @ApiOperation(value = "Excluindo uma tarefa")
    @ApiResponses({
            @ApiResponse(code = 204, message = "Tarefa excluida com sucesso"),
            @ApiResponse(code = 404, message = "Não foi possivel excluir a tarefa - tarefa não encontrada")
    })
    @DeleteMapping("delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> deleteTaskById (@PathVariable (value = "id") Long id){
        log.info("Excluindo tarefas com o id [{}]", id);
        return taskService.deleteById(id);
    }
}
