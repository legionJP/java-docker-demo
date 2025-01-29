package com.jmicroservice.SpringQuizApp1.controller;

import com.jmicroservice.SpringQuizApp1.model.Question;
import com.jmicroservice.SpringQuizApp1.model.QuestionWrapper;
import com.jmicroservice.SpringQuizApp1.model.Response;
import com.jmicroservice.SpringQuizApp1.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title)
    {
        // return new ResponseEntity<>("Quiz created", HttpStatus.OK);
        return  quizService.createQuiz(category,numQ,title);

    }
// queryparam for @RequestParam  /quiz/create?category=ASDER&numQ=11&question=What%20is%20the%20ternary%20loop%20in%20Java&title=Loop

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuestions(@PathVariable Integer id)
    {
        // creating the wrapper of Questions which will not have the answers
        return quizService.getQuizQuestions(id);

    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> response)
    {
        return  quizService.calculateResult(id, response);
    }
}
//@RequestParam String question,
