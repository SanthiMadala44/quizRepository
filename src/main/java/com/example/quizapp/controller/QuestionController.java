package com.example.quizapp.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.quizapp.service.QuestionService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import com.example.quizapp.model.Question;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController //@RestController annotation indicates that this class is a Controller and it will be used to handle HTTP requests.
@RequestMapping("/question") // /question/* @RequestMapping  is used to map the URL with controller class
public class QuestionController {
    @Autowired //@Autowired is used to inject the dependency
    QuestionService questionService; 

    // http://localhost:8082/question/all -> will return all questions from database
    @GetMapping("/allQuestion")
    public ResponseEntity<List<Question>> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    //  http://localhost:8431/question/category?cat=java -> will return category type of question
    @GetMapping("/category/{cat}")
    public List<Question> getMethodName(@PathVariable("cat") String category) {
        return questionService.getQuestionsByCategory(category);
    }

    // http:localhost:8082/question/add  -> create new question and save 
    @PostMapping("/add")
    public ResponseEntity<String> postMethodName(@RequestBody Question question) {  
        return questionService.addQuestion(question);
    }
    
    // http:localhost:8082/question/id -> update a particular record in db based on id
    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable("id") int id){
        return questionService.deleteById(id);
    }

    // http:localhost:8082/question -> update a particular record in db based on id
    @PutMapping("/update/{id}")
    public String putMethodName(@PathVariable int id, @RequestBody Question question) { 
        return questionService.updateQuestion(id,question);
    }
}
