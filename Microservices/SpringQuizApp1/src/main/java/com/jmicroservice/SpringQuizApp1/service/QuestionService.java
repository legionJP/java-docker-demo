package com.jmicroservice.SpringQuizApp1.service;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.core.spi.AbstractComponentTracker;
import com.jmicroservice.SpringQuizApp1.model.Question;
import com.jmicroservice.SpringQuizApp1.dao.QuestionDao;
//import org.slf4j.LoggerFactory;

import ch. qos. logback. classic. Logger;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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
//    @Transactional
//    public  ResponseEntity<String> addQuestions(Question question) {
//        questionDao.save(question);
//        return new ResponseEntity<>("Question added successfully", HttpStatus.OK);
//    }


      //  public String addQuestions(Question question) {
//            if (question.getId() != null) {
//                Question existingQuestion = entityManager.find(Question.class, question.getId());
//                if (existingQuestion != null) {
//                    entityManager.merge(question);
//                } else {
//                    // Handle case where entity does not exist
//                    return "Question not found, cannot update!";
//                }
//            } else {
//                entityManager.persist(question);
//            }
//            return "Question added/updated successfully!";

}
