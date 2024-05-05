package com.example.cruddemo;

import com.example.cruddemo.dao.StudentDAO;
import com.example.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
            //createStudent(studentDAO);

            //createMultipleStudents(studentDAO);

            //readStudent(studentDAO);

            //queryForStudents(studentDAO);

            //queryForStudentsByLastName(studentDAO);

            //updateStudent(studentDAO);

            //deleteStudent(studentDAO);

            //deleteAll(studentDAO);
        };
    }

    private void deleteAll(StudentDAO studentDAO) {
        System.out.println("Deleting all students");
        int deletedRowCount = studentDAO.deleteAll();
        System.out.println("Deleted " + deletedRowCount + " students");
    }

    private void deleteStudent(StudentDAO studentDAO) {
        int studentId = 3;
        System.out.println("Deleting student: " + studentId);
        studentDAO.delete(studentId);
    }

    private void updateStudent(StudentDAO studentDAO) {
        // retrieve student based on the id: primary key
        int studentId = 1;
        System.out.println("Getting student with id: " + studentId);
        Student foundStudentId = studentDAO.findById(studentId);

        //change first name to "Scooby"
        System.out.println("Updating student...");
        foundStudentId.setFirstName("Shaggy");

        //update student
        studentDAO.update(foundStudentId);

        //display the updated student
        System.out.println("Updated Student: " + foundStudentId);
    }

    private void queryForStudentsByLastName(StudentDAO studentDAO) {
        //get a list of students
        List<Student> students = studentDAO.findByLastName("Duck");

        //display list of students
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private void queryForStudents(StudentDAO studentDAO) {
        //get a list of students
        List<Student> students = studentDAO.findAll();

        //display list of students
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private void readStudent(StudentDAO studentDAO) {
        //create a student
        System.out.println("Creating student...");
        Student tempStudent1 = new Student("Daffy","Duck","daffy@gmail.com");

        //save student
        System.out.println("Saving student...");
        studentDAO.save(tempStudent1);

        //display id of the saved student
        int id = tempStudent1.getId();
        System.out.println("Saved student: " + id);

        //retrieve student based on id
        System.out.println("Retrieving student...");
        Student student1 = studentDAO.findById(id);

        //display student
        System.out.println("Found student: " + student1);

    }

    private void createMultipleStudents(StudentDAO studentDAO) {
        //create multiple students
        System.out.println("Creating student...");
        Student tempStudent1 = new Student("Kamal","Ranna","kamal@gmail.com");
        Student tempStudent2 = new Student("Nimala","Kulla","nimala@gmail.com");
        Student tempStudent3 = new Student("Suman","Aara","suman@gmail.com");

        //save the students
        System.out.println("Saving students...");
        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);
    }

    private void createStudent(StudentDAO studentDAO) {
        //Create a new student
        System.out.println("Creating student...");
        Student tempStudent = new Student("Kamal","Ranna","kamal@gmail.com");

        //save a student
        System.out.println("Saving student...");
        studentDAO.save(tempStudent);

        //display id of the saved student
        System.out.println("Saved Student generated Id: " + tempStudent.getId());
    }

}
