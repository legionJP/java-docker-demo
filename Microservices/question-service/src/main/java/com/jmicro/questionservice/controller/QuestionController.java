package com.jmicro.questionservice.controller;

import com.jmicro.questionservice.model.Question;
import com.jmicro.questionservice.model.QuestionWrapper;
import com.jmicro.questionservice.model.Response;
import com.jmicro.questionservice.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/question")
public class QuestionController    {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/allQuestions")
   // public List<Question> getAllQuestions()
    public  ResponseEntity<List<Question>> getAllQuestions()
    {
           return questionService.getAllQuestions();
       // return  new ResponseEntity<>(questionService.getAllQuestions(), HttpStatus.OK) ; // or can be done in the service layer

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
// Generate Questions

    @GetMapping("generate")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String categoryName, @RequestParam Integer numQuestions) {
        return questionService.getQuestionsForQuiz(categoryName, numQuestions);
    }
// Get Questions id
    @PostMapping("getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionIds) {
        return  questionService.getQuestionsFromId(questionIds);

    }

// get Scores
    @PostMapping("getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses)
    {
        return  questionService.getScore(responses);
    }
}

// Controller ----> Service layer(Business logic) ---> DAO(data layer--> connect db and fetch) ---> Database
