package ru.javarush.golf.lykova.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import ru.javarush.golf.lykova.dao.TaskDao;
import ru.javarush.golf.lykova.entity.Status;
import ru.javarush.golf.lykova.entity.TaskEntity;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskDao taskDao;

    private static final int PAGE_SIZE = 10;

    public Page<TaskEntity> findAllTasks(int pageNumber) {
        return taskDao.findAll(pageNumber - 1, PAGE_SIZE);
    }

    public void saveTask(String description, Status status) {
        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setDescription(description);
        taskEntity.setStatus(status);
        taskDao.saveTask(taskEntity);
    }

    public void deleteTask(int id) {
        taskDao.deleteTask(id);
    }
}
