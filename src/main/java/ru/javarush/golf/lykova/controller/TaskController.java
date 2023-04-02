package ru.javarush.golf.lykova.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.javarush.golf.lykova.entity.Status;
import ru.javarush.golf.lykova.entity.TaskEntity;
import ru.javarush.golf.lykova.service.TaskService;

import java.util.List;
import java.util.stream.IntStream;

@Controller
@RequestMapping("api")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("task")
    public String tasksList(Model model,
                            @RequestParam int pageNumber) {
        Page<TaskEntity> taskPage = taskService.findAllTasks(pageNumber);
        model.addAttribute("taskPage", taskPage);
        List<Integer> pagesNumbers = IntStream.range(1, taskPage.getTotalPages() + 1).boxed().toList();
        model.addAttribute("pagesNumbers", pagesNumbers);
        model.addAttribute("statusList", Status.values());
        return "task";
    }

    @PostMapping(value = "task", consumes = "application/x-www-form-urlencoded")
    public String saveTask(Model model,
                           @RequestParam(required = false) Integer id,
                           @RequestParam String description,
                           @RequestParam Status status) {
        taskService.saveTask(id, description, status);
        return tasksList(model, 1);
    }

    @PostMapping(value = "deleteTask", consumes = "application/x-www-form-urlencoded")
    public String deleteTask(Model model,
                           @RequestParam int taskId) {
        taskService.deleteTask(taskId);
        return tasksList(model, 1);
    }

}
