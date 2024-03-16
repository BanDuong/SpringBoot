package com.demo_spring.basic.configs;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.demo_spring.basic.model.Student;
import com.demo_spring.basic.repositories.StudentRepository;

@Configuration
public class StudentConfig {
    
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student john = new Student(
                "john",
                "john@gmail.com",
                LocalDate.of(2000, 1, 1)
            );

            Student mary = new Student(
                "mary",
                "mary@gmail.com",
                LocalDate.of(2001, 11, 12)
            );
            
            repository.saveAll(
                List.of(mary, john)
            );
        };
    }
}
