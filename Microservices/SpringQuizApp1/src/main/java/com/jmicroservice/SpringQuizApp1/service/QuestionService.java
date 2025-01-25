package com.jmicroservice.SpringQuizApp1.service;

import com.jmicroservice.SpringQuizApp1.Question;
import com.jmicroservice.SpringQuizApp1.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;

    public List<Question> getAllQuestions()
    {
//        return questionDao.getAllQuestions();
        return questionDao.findAll();


    }

    public List<Question> getQuestionsByCategory(String category) {
        return questionDao.findByCategory(category);
    }
}
