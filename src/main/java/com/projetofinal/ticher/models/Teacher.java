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

    private String cpf;

    private String phone;

    @ManyToMany
    @JoinTable(name = "teacher_subjects",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id"))
    private List<Subject> subjects = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "teachers")
    private final List<Evaluation> evaluations = new ArrayList<>();

    @Column(nullable = false, updatable = false)
    private final Instant createdIn = Instant.now();

    @Deprecated
    private Teacher() {
    }

    public Teacher(String name, List<Subject> subjectsList, String email, String password) {
        super.email = email;
        super.password = password;
        this.name = name;
        this.subjects = subjectsList;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public String getPhone() {
        return phone;
    }

    public List<Subject> getSubjects() {
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
