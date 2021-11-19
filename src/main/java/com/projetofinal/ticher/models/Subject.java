package com.projetofinal.ticher.models;

import javax.persistence.*;
import java.time.Instant;

@Entity
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, length = 1000)
    private String description;

    @ManyToOne
    private Teacher teachers;

    @Column(nullable = false, updatable = false)
    private final Instant createdIn = Instant.now();

    @Deprecated
    private Subject() {
    }

    public Subject(String name, String description, Teacher teachers) {
        this.name = name;
        this.description = description;
        this.teachers = teachers;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

}
