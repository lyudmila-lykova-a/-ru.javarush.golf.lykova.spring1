package ru.javarush.golf.lykova.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javarush.golf.lykova.dao.TaskDao;
import ru.javarush.golf.lykova.entity.TaskEntity;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskDao taskDao;

    public List<TaskEntity> findAllTasks(int pageNumber) {
        return taskDao.findAll(pageNumber - 1, 10);
    }

}
