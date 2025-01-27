package com.jmicroservice.SpringQuizApp1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String question, @RequestParam String title)
    {
        return new ResponseEntity<>("Quiz created", HttpStatus.OK);
    }
}
