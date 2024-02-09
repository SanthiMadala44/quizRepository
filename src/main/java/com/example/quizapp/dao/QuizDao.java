package com.example.quizapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.quizapp.model.Quiz;

@Repository
public interface QuizDao extends JpaRepository<Quiz,Integer>{

    // @Query(value = "select * from question q where q.category=:category ORDER BY RANDOM() LIMIT :numQ",nativeQuery=true)
    // List<Question> findRandomQuestionByCategory(String category, int numQ);

}
