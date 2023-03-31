package ru.javarush.golf.lykova.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.javarush.golf.lykova.service.TaskService;

@Controller
@RequestMapping("api")
public class DemoController {

    @Autowired
    private TaskService taskService;

    @GetMapping("task")
    public String tasksList(Model model,
                            @RequestParam int pageNumber) {
        model.addAttribute("tasks", taskService.findAllTasks(pageNumber));
        return "task";
    }

}
