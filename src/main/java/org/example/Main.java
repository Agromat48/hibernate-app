package org.example;

import org.example.service.ProfileService;
import org.example.service.StudentService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDateTime;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext("org.example");

        SessionFactory sessionFactory = context.getBean(SessionFactory.class);

        StudentService studentService = context.getBean(StudentService.class);
        ProfileService profileService = context.getBean(ProfileService.class);

        Student student1 = new Student("Vasya", 22);
        Student student2 = new Student("Pasha", 23);

        studentService.saveStudent(student1);
        studentService.saveStudent(student2);

        Profile profile1 = new Profile("mi bio", LocalDateTime.now(), student1);
        profileService.saveProfile(profile1);
    }
}