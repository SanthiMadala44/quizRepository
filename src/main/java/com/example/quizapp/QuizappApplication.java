package com.example.quizapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication is combination of @Configuration, @EnableAutoConfiguration and @ComponentScan
//@Configuration used for creating beans at runtime by the  Spring container
//@EnableAutoConfiguration enables auto-configuration of beans based on classes present in the classpath
//@ComponentScan tells spring to look for other components (classes annotated with @Component) and register
//them as beans if they are not registered explicitly
@SpringBootApplication
public class QuizappApplication {

	//main method which will start our application when we run this java file directly from command line
	public static void main(String[] args) {
		//run()  method starts the Spring Boot Application context
		//.class  gets the Class object for the  current class
		//args    provides access to command line arguments passed to the Java Virtual Machine
		SpringApplication.run(QuizappApplication.class, args);
	}
}
