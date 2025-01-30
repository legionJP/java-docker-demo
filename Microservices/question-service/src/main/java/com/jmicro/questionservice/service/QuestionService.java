package com.jmicro.questionservice.service;

import ch.qos.logback.classic.Logger;
import com.jmicro.questionservice.model.Question;
import com.jmicro.questionservice.dao.QuestionDao;
//import org.slf4j.LoggerFactory;

import com.jmicro.questionservice.model.QuestionWrapper;
import com.jmicro.questionservice.model.Response;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public ResponseEntity<List<Integer>> getQuestionsForQuiz(String categoryName, Integer numQuestions) {
        List<Integer> questions=  questionDao.findRandomQuestionsByCategory(categoryName, numQuestions);

        return new ResponseEntity<>(questions, HttpStatus.OK);

    }


    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(List<Integer> questionIds) {
        //getting questions wrapper
        List<QuestionWrapper> wrappers = new ArrayList<>();
        List<Question> questions = new ArrayList<>();

        for(Integer questionId : questionIds) {
            questions.add(questionDao.findById(questionId).get());


        }
        // now iterating from the wrappers
        for(Question question : questions) {
            QuestionWrapper wrapper = new QuestionWrapper();
            wrapper.setId(question.getId());
            wrapper.setOption1(question.getOption1());
            wrapper.setOption2(question.getOption2());
            wrapper.setOption3(question.getOption3());
            wrapper.setOption4(question.getOption4());
            wrapper.setQuestionTitle(question.getQuestionTitle());
            wrappers.add(wrapper);


        }
        return new ResponseEntity<>(wrappers, HttpStatus.OK);

    }

    public ResponseEntity<Integer> getScore(List<Response> responses) {
        int right=0;
        for(Response r : responses) {
            Optional<Question> question = questionDao.findById(r.getId());
            if(r.getResponse().equals(question.get().getRightAnswer()))
                right++;
        }
        return  new ResponseEntity<>(right, HttpStatus.OK);
    }
}
