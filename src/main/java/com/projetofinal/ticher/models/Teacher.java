package com.projetofinal.ticher.models;

import com.projetofinal.ticher.api.dto.SubjectRequest;
import com.projetofinal.ticher.models.abstracts.Login;

import javax.persistence.*;
import javax.validation.Valid;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public class Teacher extends Login {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "teachers", cascade = CascadeType.PERSIST)
    private final Set<Subject> subjects = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "teachers")
    private final List<Evaluation> evaluations = new ArrayList<>();

    @Column(nullable = false, updatable = false)
    private final Instant createdIn = Instant.now();

    @Deprecated
    private Teacher() {
    }

    public Teacher(String name, @Valid Set<SubjectRequest> subjectsList, String email, String password) {
        super.email = email;
        super.password = password;
        this.name = name;
        // add items do subjectsList para a propriedade subjects
        this.subjects.addAll(subjectsList.stream()
                // pra cada index da subjectsList ele usa
                // o método pra transformar request em entity
                .map(subjectRequest -> subjectRequest.toSubject(this))
                // por fim joga as entity pra dentro da lista
                .collect(Collectors.toSet()));
    }

    public String getName() {
        return name;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subjects=" + subjects +
                ", createdIn=" + createdIn +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
