package ru.javarush.golf.lykova.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.javarush.golf.lykova.entity.TaskEntity;
import ru.javarush.golf.lykova.repository.TaskRepository;

import java.util.List;

@Component
public class TaskDao {

    @Autowired
    private TaskRepository taskRepository;

    public List<TaskEntity> findAll() {
        return taskRepository.findAll();
    }

}
