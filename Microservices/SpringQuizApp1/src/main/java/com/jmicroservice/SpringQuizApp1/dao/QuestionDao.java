package com.jmicroservice.SpringQuizApp1.dao;

import com.jmicroservice.SpringQuizApp1.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {

    List<Question> findByCategory(String category);  // by the dataJPA , use jPQL or HQL for customization
}

