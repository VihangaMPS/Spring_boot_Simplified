package com.example.demo.rest;

import com.example.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRESTController {

    private List<Student> students;

    //define @PostConstruct to load the student data ... only once !
    @PostConstruct
    public void loadData() {
        students = new ArrayList<>();

        students.add(new Student("Poornima", "Patel"));
        students.add(new Student("Mario", "Rossy"));
        students.add(new Student("Karl", "Smith"));
    }

    //define endpoint for "/students" - return a list of students
    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    //define endpoint or "/student/{}studentId" - return student at index
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        //check the studentId again list size
        if ((studentId >= students.size()) || (studentId < 0) ) {
            throw  new StudentNotFoundException("Student id not found : " + studentId);
        }

        return students.get(studentId);
    }


}
