package ru.javarush.golf.lykova.dao;

import org.springframework.beans.factory.annotation.Autowired;
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

    public List<TaskEntity> findAll(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Order.asc("id")));
        return taskRepository.findAll(pageable).getContent();
    }

}
