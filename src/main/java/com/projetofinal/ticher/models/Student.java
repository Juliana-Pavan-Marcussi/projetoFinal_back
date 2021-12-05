package com.projetofinal.ticher.models;

import com.projetofinal.ticher.models.abstracts.Login;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student extends Login {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String cpf;

    private String phone;

    @Column(nullable = false, updatable = false)
    private final Instant createdIn = Instant.now();

    @Deprecated
    private Student() {}

    public Student(String name, String email, String cpf, String phone, String password) {
        this.name = name;
        super.email = email;
        this.cpf = cpf;
        this.phone = phone;
        super.password = password;
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

}
