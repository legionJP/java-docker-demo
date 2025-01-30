package com.jmicro.quizservice.service;

import com.jmicro.quizservice.dao.QuizDao;
import com.jmicro.quizservice.model.QuestionWrapper;
import com.jmicro.quizservice.model.Quiz;
import com.jmicro.quizservice.model.Response;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.lang.String;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

//    @Autowired
//    QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
//        List<TypePatternQuestions.Question> questions = questionDao.findRandomQuestionsByCategory(category, numQ);
//        Quiz quiz = new Quiz();
//        quiz.setTitle(title);
//        quiz.setQuestions(questions); //fetch from db
//        quizDao.save(quiz);
        return  new ResponseEntity<>("Quiz Created", HttpStatus.CREATED);

    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        Optional<Quiz> quiz = quizDao.findById(id); // optional to counter null value
        List<Question> questionsFromDB=quiz.get().getQuestions();
        List<QuestionWrapper> questionsForUsers = new ArrayList<>();

        for (Question q : questionsFromDB) {
            QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            questionsForUsers.add(qw); //filling the questions for the users
        }
        return  new ResponseEntity<>(questionsForUsers, HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> response) {
        Quiz quiz = quizDao.findById(id).get();
        List<Question> questions = quiz.getQuestions();

        int right=0;
        int i=0;
        for(Response r : response) {
            if(r.getResponse().equals(questions.get(i).getRightAnswer()))
                right++;
            i++;
        }
        return  new ResponseEntity<>(right, HttpStatus.OK);
    }
}
