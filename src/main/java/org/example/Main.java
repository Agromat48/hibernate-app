package org.example;

import org.example.service.GroupService;
import org.example.service.ProfileService;
import org.example.service.StudentService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDateTime;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext("org.example");

        SessionFactory sessionFactory = context.getBean(SessionFactory.class);

        StudentService studentService = context.getBean(StudentService.class);
        ProfileService profileService = context.getBean(ProfileService.class);
        GroupService groupService = context.getBean(GroupService.class);

        Group group1 = groupService.saveGroup("1", 2024L);
        Group group2 = groupService.saveGroup("2", 2024L);
        Group group3 = groupService.saveGroup("3", 2024L);

        Student student1 = new Student("Vasya", 22, group1);
        Student student2 = new Student("Pasha", 23, group1);

        studentService.saveStudent(student1);
        studentService.saveStudent(student2);

        groupService.findAll();
    }
}