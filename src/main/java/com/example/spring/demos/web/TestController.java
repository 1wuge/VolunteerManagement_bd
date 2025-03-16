package com.example.spring.demos.web;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("test")
public class TestController {
    @RequestMapping("test1")
    public String Test()
    {
        return "nihjjjao";
    }
}
