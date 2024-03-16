package com.demo_spring.basic.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo_spring.basic.model.Student;
import com.demo_spring.basic.repositories.StudentRepository;

import jakarta.transaction.Transactional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
        
    }

    public void addNewStudent(Student student){
        
        Optional<Student> studentByEmail =  studentRepository.findStudentByEmail(student.getEmail());
        if(studentByEmail.isPresent()){
            throw new IllegalStateException("email taken already");
        }
        studentRepository.save(student);
        // System.out.println(student);
    }

    public void deleteStudent(long studentId){
        boolean existStudent = studentRepository.existsById(studentId);
        if(!existStudent){
            throw new IllegalStateException("student with " + studentId  + " not found!");
        }
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(long studentId, Student bodyStudent){
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new IllegalArgumentException("student with " + studentId  + " not found!"));
        student.setName(bodyStudent.getName());
        student.setEmail(bodyStudent.getEmail());
    }

    public Student getOneStudent(long studentId){
            return studentRepository.findById(studentId).orElseThrow(() -> new IllegalArgumentException("student with " + studentId  + " not found!"));
    }
}
