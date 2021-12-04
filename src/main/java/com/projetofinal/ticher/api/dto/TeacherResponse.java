package com.projetofinal.ticher.api.dto;

import com.projetofinal.ticher.models.Subject;
import com.projetofinal.ticher.models.Teacher;

import java.util.List;

public class TeacherResponse {
    private String name;

    private String email;

    private List<Subject> subjects;

    public TeacherResponse(Teacher teacher) {
        this.name = teacher.getName();
        this.email = teacher.getEmail();
        this.subjects = teacher.getSubjects();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }
}
