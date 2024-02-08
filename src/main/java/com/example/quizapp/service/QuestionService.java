package com.example.quizapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.quizapp.Question;
import com.example.quizapp.dao.QuestionDAO;

import java.util.List;

@Service // Indicates that this class is a service layer
public class QuestionService {

    @Autowired // Injects the dependency of questionDao into this class
    QuestionDAO questionDao; 

    // Returns all questions from the database as a response entity with status code OK if successful, or BAD
    public ResponseEntity<List<Question>> getAllQuestions() {
        try{
            return  new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);//Returns a list of all questions with status code 200
        }catch(Exception e){
            e.printStackTrace();
        }
        return  new ResponseEntity<>(questionDao.findAll(), HttpStatus.BAD_REQUEST); // Returns all questions in the database if successful, otherwise returns BAD_REQUEST
    }

    // Returns all questions for a given quizId
    public List<Question> getQuestionsByCategory(String category) {
        List<Question> questions = questionDao.findByCategory(category);
        return  questions;
    }

    // Adds a new question to the database
    public ResponseEntity<String> addQuestion(Question question) {
        questionDao.save(question);
        return new ResponseEntity<> ("SUCCESS", HttpStatus.CREATED);
    }

    // Updates an existing question in the database
    public String deleteById(int id) {
        questionDao.deleteById(id);
        return "Successfully Deleted the question with Id : "+id;
    }

    // Get method to retrieve a single record by its ID
    public String updateQuestion(int id, Question question) {
        @SuppressWarnings("deprecation")
        Question updaQuestion = questionDao.getOne(id);
        if(questionDao.existsById(id)){
            if (question.getCategory() != null) { 
                updaQuestion.setCategory(question.getCategory());
            }
            if (question.getDifficultylevel() != null) { 
                updaQuestion.setDifficultylevel(question.getDifficultylevel());
            }
            questionDao.save(updaQuestion);
        }
        return "Updated  Successfully with : " + id;
    }

}
