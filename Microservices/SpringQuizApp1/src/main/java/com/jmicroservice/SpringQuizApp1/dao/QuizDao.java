package com.jmicroservice.SpringQuizApp1.dao;

import com.jmicroservice.SpringQuizApp1.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizDao extends JpaRepository<Quiz, Integer> {

}
