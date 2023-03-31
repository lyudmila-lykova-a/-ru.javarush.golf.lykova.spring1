package ru.javarush.golf.lykova.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.javarush.golf.lykova.service.DemoService;

@Controller
@RequestMapping("api")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @RequestMapping(value = "demo", method = RequestMethod.GET)
    public String findAllTasks() {
        return "demo";
    }

}
