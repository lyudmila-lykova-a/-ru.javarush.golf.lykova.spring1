package ru.javarush.golf.lykova.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import ru.javarush.golf.lykova.entity.TaskEntity;
import ru.javarush.golf.lykova.repository.TaskRepository;

import java.util.List;

@Component
public class TaskDao {

    @Autowired
    private TaskRepository taskRepository;

    public Page<TaskEntity> findAll(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Order.asc("id")));
        return taskRepository.findAll(pageable);
    }

    public void saveTask(TaskEntity taskEntity) {
        taskRepository.save(taskEntity);
    }

    public void deleteTask(int id) {
        taskRepository.deleteById(id);
    }
}
