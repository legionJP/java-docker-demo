package com.jmicroservice.SpringQuizApp1.dao;

//import com.jmicroservice.SpringQuizApp1.Question;
import com.jmicroservice.SpringQuizApp1.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {

    List<Question> findByCategory(String category);  // by the dataJPA , use jPQL or HQL for customization

    @Query(value = "SELECT * FROM questions q WHERE q.category= :category ORDER BY RANDOM() LIMIT :numQ", nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(String category, int numQ);
}

