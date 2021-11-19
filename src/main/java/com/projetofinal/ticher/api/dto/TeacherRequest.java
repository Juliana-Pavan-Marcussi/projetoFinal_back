package com.projetofinal.ticher.api.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.projetofinal.ticher.models.Teacher;

import javax.validation.constraints.*;
import java.util.List;
import java.util.Set;

public class TeacherRequest {

    @NotBlank
    @Size(min=2, max=200)
    private final String name;

    @NotBlank
    @Email
    private final String email;

    @NotNull
    @NotBlank
    @Size(min=4)
    private final String password;

    private final Set<SubjectRequest> subjects;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public TeacherRequest(String name, String email, String password, Set<SubjectRequest> subjects) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.subjects = subjects;
    }

    public Teacher toTeacher() {
        return new Teacher(this.name, this.subjects, this.email, this.password);
    }

    @Override
    public String toString() {
        return "TeacherRequest{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", subjects=" + subjects +
                '}';
    }
}
