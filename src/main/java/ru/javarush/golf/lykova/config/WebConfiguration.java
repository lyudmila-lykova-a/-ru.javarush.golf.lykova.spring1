package ru.javarush.golf.lykova.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = {
        "ru.javarush.golf.lykova.controller",
        "ru.javarush.golf.lykova.service",
        "ru.javarush.golf.lykova.dao"
})
public class WebConfiguration implements WebMvcConfigurer {
}
