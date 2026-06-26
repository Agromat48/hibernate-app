package org.example;

import org.example.service.StudentService;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext("org.example");

        SessionFactory sessionFactory = context.getBean(SessionFactory.class);
        StudentService studentService = new StudentService(sessionFactory);

        Student student1 = new Student("Vasya", 22);
        Student student2 = new Student("Pasha", 23);

        studentService.saveStudent(student1);
        studentService.saveStudent(student2);
    }
}