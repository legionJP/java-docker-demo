package com.jmicro.questionservice.service;

import ch.qos.logback.classic.Logger;
import com.jmicro.questionservice.model.Question;
import com.jmicro.questionservice.dao.QuestionDao;
//import org.slf4j.LoggerFactory;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;

    private static final Logger logger = (Logger) LoggerFactory.getLogger(QuestionService.class);

    @Autowired
    private EntityManager entityManager;
    public ResponseEntity<List<Question>> getAllQuestions()

    {
        try {
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);

        }catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);


    }
// return  the questions based on category
    public List<Question> getQuestionsByCategory(String category) {
        logger.info("Fetching questions for category: {}", category);
        return questionDao.findByCategory(category);
    }

    @Transactional
    public String addQuestions(Question question) {
        questionDao.save(question);
        return "Question added successfully";
    }

    public ResponseEntity<List<Integer>> getQuestionsForQuiz(String categoryName, String numQuestions) {
        List<Question> questions=  questionDao.findRandomQuestionsByCategory(categoryName, numQuestions);


    }

}
