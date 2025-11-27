package com.app.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "<div style='text-align:center; margin-top:50px; font-size:40px; font-weight:bold;'>"
                + "Hello DevOps!"
                + "</div>";
    }
}

