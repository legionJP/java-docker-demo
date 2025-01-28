package com.jmicroservice.SpringQuizApp1.controller;

import com.jmicroservice.SpringQuizApp1.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String question, @RequestParam String title)
    {
        return new ResponseEntity<>("Quiz created", HttpStatus.OK);
    }
// queryparam for @RequestParam  /quiz/create?category=ASDER&numQ=11&question=What%20is%20the%20ternary%20loop%20in%20Java&title=Loop
}
