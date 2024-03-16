package com.demo_spring.basic.model;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Table
@Getter
@Setter
// @NoArgsConstructor: set Non constructor
// @AllArgsConstructor: set constructor
// @Data
// @Builder: builder a new model 
@FieldDefaults(level = AccessLevel.PRIVATE) // : set variables are type of PRIVATE
public class Student {

    @Id
    @SequenceGenerator(
        name = "student_seq",
        sequenceName = "student_seq",
        allocationSize = 1
    )    

    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "student_seq"
    )    
    
//     @GeneratedValue(strategy = GenerationType.UUID)17
//     private String id;

    long id;
    String name;
    String email;
    LocalDate dob;
    @Transient
    int age;


    public Student(){}

    public Student(String name, String email, LocalDate dob){
        // this.id = id;
        this.name = name;
        // this.age = age;
        this.email = email;
        this.dob = dob;
    }
    // getters and setters for all the fields of student are written here

    @Override
    public String toString() {
        return "Student{" +
                "id=" + this.id +
                ", name='" + this.name + '\'' +
                ", age=" + this.age +
                ", email='" + this.email + '\'' +
                ", dob=" + this.dob +
                '}';
    }

//     public long getId() {
//             return id;
//     }
//     public void setId(long id) {
//             this.id = id;
//     }

//     public String getName() {
//             return name;
//     }
//     public void setName(String name) {
//             this.name = name;
//     }

//     public int getAge() {
//             return Period.between(this.dob, LocalDate.now()).getYears();
//     }
//     public void setAge(int age) {
//             if (age > 0 )
//                 this.age = age;
//     }

//     public LocalDate getDob() {
//             return dob;
//     }
//     public void setDob(LocalDate dob){
//         this.dob = dob;
//     }

//     public String getEmail() {
//             return email;
//     }

//     public void setEmail(String email) {
//             this.email = email;
//     }
} 

