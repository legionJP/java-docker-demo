package com.jmicroservice.SpringQuizApp1.service;

import com.jmicroservice.SpringQuizApp1.dao.QuizDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

}
