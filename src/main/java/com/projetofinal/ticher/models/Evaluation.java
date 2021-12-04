package com.projetofinal.ticher.models;

import javax.persistence.*;

@Entity
public class Evaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Integer score;

    @ManyToOne
    private Student students;

    @ManyToOne
    private Teacher teachers;

    @Deprecated
    private Evaluation() {
    }

    public Evaluation(String title, String description, Integer score, Student students, Teacher teachers) {
        this.title = title;
        this.description = description;
        this.score = score;
        this.students = students;
        this.teachers = teachers;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Integer getScore() {
        return score;
    }

    public Student getStudents() {
        return students;
    }

    public Teacher getTeachers() {
        return teachers;
    }
}
