package com.jp.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
   
   @RequestMapping("/")
    public String greet()
    {
        return "Hello Docker";
    }
}