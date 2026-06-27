package org.example;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
@SuppressWarnings("JpaDataSourceORMInspection")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Student() {
    }

    public Student(String name, Integer age, Group group) {
        this.name = name;
        this.age = age;
        this.group = group;
    }

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "student_age")
    private Integer age;

    @OneToOne(mappedBy = "student", cascade = CascadeType.REMOVE)
    private Profile profile;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Integer getAge() {
        return age;
    }
}
