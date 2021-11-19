package com.projetofinal.ticher.models;

import com.projetofinal.ticher.models.enums.StatusClassEnum;

import javax.persistence.*;
import java.time.Instant;

@Entity
public class Class {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusClassEnum statusClass;

    @OneToOne
    private TeacherAvailability teacherAvailability;

    @OneToOne
    private Student student;

    @Column(nullable = false, updatable = false)
    private final Instant createdIn = Instant.now();

    @Deprecated
    public Class() {}

}
