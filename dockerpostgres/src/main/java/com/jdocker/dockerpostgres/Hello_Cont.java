package com.jdocker.dockerpostgres;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello_Cont {
    
    @GetMapping("/hello")
    public String hello()
    {
        return "Welcome";
    }
}
