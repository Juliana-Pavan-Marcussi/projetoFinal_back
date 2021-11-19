package com.projetofinal.ticher.models;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;

@Entity
public class TeacherAvailability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private String hours;

    @OneToOne
    private Teacher teacher;

    @Column(nullable = false, updatable = false)
    private final Instant createdIn = Instant.now();

    @Deprecated
    private TeacherAvailability() {
    }

    public TeacherAvailability(LocalDate date, String hours, Teacher teacher) {
        this.date = date;
        this.hours = hours;
        this.teacher = teacher;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getHours() {
        return hours;
    }

    public Teacher getTeacher() {
        return teacher;
    }

}
