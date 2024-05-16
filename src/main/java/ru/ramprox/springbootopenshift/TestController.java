package ru.ramprox.springbootopenshift;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/api/v1/time")
public class TestController {

    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    @GetMapping("/now")
    public String now() {
        return "Текущая дата и время: %s".formatted(dateTimeFormatter.format(LocalDateTime.now()));
    }
}
