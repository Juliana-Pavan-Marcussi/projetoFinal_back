package com.projetofinal.ticher.api.dto;

import com.projetofinal.ticher.models.Student;

public class StudentResponse {
    private String name;

    private String email;

    public StudentResponse(Student student) {
        this.name = student.getName();
        this.email = student.getEmail();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}