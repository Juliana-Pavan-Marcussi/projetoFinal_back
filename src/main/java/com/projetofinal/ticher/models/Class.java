package com.projetofinal.ticher.models;

import javax.persistence.*;
import java.time.Instant;

@Entity
public class Class {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.MERGE)
    private TeacherAvailability teacherAvailability;

    @OneToOne
    private Student student;

    @Column(nullable = false, updatable = false)
    private final Instant createdIn = Instant.now();

    @Deprecated
    private Class() {}

    public Class(TeacherAvailability teacherAvailability, Student student) {
        this.teacherAvailability = teacherAvailability;
        this.student = student;
    }

    public TeacherAvailability getTeacherAvailability() {
        return teacherAvailability;
    }

    public Student getStudent() {
        return student;
    }
}
