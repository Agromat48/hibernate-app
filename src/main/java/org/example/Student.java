package org.example;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Student() {
    }

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    private String name;

    private Integer age;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
