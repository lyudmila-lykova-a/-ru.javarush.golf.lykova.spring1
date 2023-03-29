package ru.javarush.golf.lykova.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javarush.golf.lykova.dao.TaskDao;
import ru.javarush.golf.lykova.entity.TaskEntity;

import java.util.List;

@Service
public class DemoService {

    @Autowired
    private TaskDao taskDao;

    public List<TaskEntity> findAllTasks() {
        return taskDao.findAll();
    }

}
