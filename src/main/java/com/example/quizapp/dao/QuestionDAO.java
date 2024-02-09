package com.example.quizapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.quizapp.model.Question;
import java.util.List;

//@Repository - marks the class as a repository
@Repository
//JpaRepository  is an interface that  extends JPA’s Repository interface and provides default implementations for CRUD (Create, Read, Update, Delete)
public interface QuestionDAO extends JpaRepository<Question, Integer> {
    List<Question> findByCategory(String category);

    @Query(value = "select * from question q where q.category=:category ORDER BY RANDOM() LIMIT :numQ",nativeQuery=true)
    List<Question> findRandomQuestionByCategory(String category, int numQ);
}
