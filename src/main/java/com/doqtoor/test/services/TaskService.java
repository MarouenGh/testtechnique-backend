package com.doqtoor.test.services;

import com.doqtoor.test.exception.RecordNotFoundException;
import com.doqtoor.test.models.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class TaskService {
    private List<Task> taskList = new ArrayList<>(Arrays.asList(

            new Task(1, "L'intsallation de l'environnement de développement"),
            new Task(2, "La conception de l'interface de connexion ainsi les differents intefaces utilisateur"),
            new Task(3, "La création des methodes de la partie backend responsable à la gestion des utilisateurs ainsi de les exposer")

    ));

    public List<Task> getAllTasks()
    {
        return taskList;
    }


    public void saveTask(Task task) throws RecordNotFoundException
    {
        Task lastTask = taskList.get(taskList.size()-1);
        long id = lastTask.getId();
        task.setId(id+1);
        taskList.add(task);
    }

    public void deleteTaskById(long id) throws RecordNotFoundException
    {
       taskList.removeIf(task -> task.getId()==id);
    }
    public void updateTask(Task task, long id) {
        int counter = 0;
        System.out.println(task);
        for (Task task1 : taskList) {
            if (task1.getId() ==  id) {
                taskList.set(counter, task);
            }
            counter++;
        }
    }
}
