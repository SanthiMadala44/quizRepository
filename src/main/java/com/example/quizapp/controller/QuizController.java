package com.example.quizapp.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.quizapp.model.Question;
import com.example.quizapp.service.QuizService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    QuizService quizService;
    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(@RequestParam String category,@RequestParam int numQ, @RequestParam String title) {
        return quizService.createQuiz(category, numQ, title);
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<List<Question>> getQuizQuestions(@PathVariable int id){
        return quizService.getQuizQuestions(id);
    }
}
