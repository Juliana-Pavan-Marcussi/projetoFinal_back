package com.projetofinal.ticher.models;

import com.projetofinal.ticher.models.enums.StatusAvailability;

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

    @Column(nullable = false)
    private Double price;

    @OneToOne
    private Teacher teacher;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusAvailability statusAvailability = StatusAvailability.OPEN;

    @Column(nullable = false, updatable = false)
    private final Instant createdIn = Instant.now();
    @Deprecated
    private TeacherAvailability() {
    }

    public TeacherAvailability(LocalDate date, String hours, Double price, Teacher teacher) {
        this.date = date;
        this.hours = hours;
        this.teacher = teacher;
        this.price = price;
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

    public StatusAvailability getStatusAvailability() {
        return statusAvailability;
    }

    public Double getPrice() {
        return price;
    }

    public void setStatusAvailability(StatusAvailability statusAvailability) {
        this.statusAvailability = statusAvailability;
    }
}