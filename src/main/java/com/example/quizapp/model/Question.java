package com.example.quizapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import lombok.Data;

@Data //@Data  - Lombok annotation to generate getters and setters for all fields in the class
@Entity //@Entity for question table  in database, @Table(name="questions") to specify the name of the table in the database
@Table(name = "question") //@Table  - JPA annotation that specifies a table name
public class Question {
    
    @Id //@Id    - JPA annotation that marks a field as a primary key
    @GeneratedValue(strategy=GenerationType.IDENTITY) //@GeneratedValue - JPA annotation that generates value for the annotated field, if it is not provided
    private Integer id;

    //@Column (name="text", nullable=false) - JPA annotation that maps a Java
    //automatically JPA creates setters and  getter methods for this field with the specified column name
    private String category;
    private String difficultylevel;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String question_title;
    private String right_answer;

}
