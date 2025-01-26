package com.jmicroservice.SpringQuizApp1.controller;

import com.jmicroservice.SpringQuizApp1.Question;
import com.jmicroservice.SpringQuizApp1.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/question")
public class QuestionController    {

    @Autowired
    private QuestionService questionService;
//    final
//    QuestionService questionService;
//
//    public QuestionController(QuestionService questionService) {
//        this.questionService = questionService;
//    }

    @GetMapping("/allQuestions")
    public List<Question> getAllQuestions()
    {
            return questionService.getAllQuestions();

    }

    @GetMapping("/category/{category}")
    public List<Question> getQuestionsByCategory(@PathVariable String category)
    {
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("/addQuestions")
    public String addQuestions(@RequestBody Question question) // json data will be converted into the request body
    {
       return questionService.addQuestions(question);
    }
}

// Controller ----> Service layer(Business logic) ---> DAO(data layer--> connect db and fetch) ---> Database
