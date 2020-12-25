package com.doqtoor.test.controllers;


import com.doqtoor.test.exception.RecordNotFoundException;
import com.doqtoor.test.models.Task;
import com.doqtoor.test.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class TaskController {
    private final Logger log = LoggerFactory.getLogger(TaskController.class);

    @Autowired
    TaskService taskService;

    @RequestMapping("/task")
    public List<Task> getAllEmployees()
    {
       return taskService.getAllTasks();
    }

    @PostMapping("/task")
    public void createTask(@RequestBody  Task task)
            throws RecordNotFoundException {
        taskService.saveTask(task);
    }

    @PutMapping("/task/{id}")
    public void updateTask(@RequestBody Task params) {
        taskService.updateTask(params, params.getId());
    }

    @DeleteMapping("/task/{id}")
    public void deleteTask(@PathVariable("id") long id)   throws RecordNotFoundException {
        log.debug("REST request to delete Task : {}", id);
        taskService.deleteTaskById(id);
    }



}
