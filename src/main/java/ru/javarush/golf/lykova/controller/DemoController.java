package ru.javarush.golf.lykova.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.javarush.golf.lykova.entity.TaskEntity;
import ru.javarush.golf.lykova.service.DemoService;

import java.util.List;

@Controller
@RequestMapping("api")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @RequestMapping(value = "demo", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
    public ResponseEntity<TaskEntity> findAllTasks() {
        TaskEntity result = demoService.findAllTasks().get(0);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(result);
    }

}
