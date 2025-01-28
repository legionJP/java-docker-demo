package com.jmicroservice.SpringQuizApp1.service;

import com.jmicroservice.SpringQuizApp1.dao.QuestionDao;
import com.jmicroservice.SpringQuizApp1.dao.QuizDao;
import com.jmicroservice.SpringQuizApp1.model.Question;
import com.jmicroservice.SpringQuizApp1.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<String> creatQuiz(String category, int numQ, String title) {
        List<Question> questions = questionDao.findRandomQuestionsByCategory(category, numQ);
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions); //fetch from db

    }
}
