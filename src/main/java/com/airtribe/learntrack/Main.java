package com.airtribe.learntrack;

import com.airtribe.learntrack.entity.Person;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.entity.Trainer;
import com.airtribe.learntrack.service.StudentService;

public class Main {
    public static void main(String[] args) {

        Person student = new Student(1, "Tony", "Ghouse", "tonyghouse@airtribe.com", "B1");
        Person trainer = new Trainer(2, "Mubina", "Begum", "mubina@airtribe.com", "Java");


        System.out.println(student.getDisplayName());
        System.out.println(trainer.getDisplayName());

        Student studentTwo = new Student(2, "K", "Ghouse", "Kghouse@airtribe.com", "B1");
        StudentService studentService = new StudentService();
        int studentTwoId = studentService.addStudent(studentTwo).getId();

        System.out.println(studentService.getStudent(studentTwoId).getEmail());
    }
}
