package com.projetofinal.ticher.api.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.projetofinal.ticher.models.Subject;
import com.projetofinal.ticher.models.Teacher;

import javax.persistence.EntityManager;
import javax.validation.constraints.*;
import java.util.ArrayList;
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

    private final List<Long> subjectIds;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public TeacherRequest(String name, String email, String password, List<Long> subjectIds) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.subjectIds = subjectIds;
    }

    public Teacher toTeacher(EntityManager entityManager) {
        List<Subject> subjectList = new ArrayList<>();
        for (Long idSubject : subjectIds){
            Subject subject = entityManager.find(Subject.class, idSubject);
            subjectList.add(subject);
        }
        return new Teacher(this.name, subjectList, this.email, this.password);
    }

    @Override
    public String toString() {
        return "TeacherRequest{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", subjects=" + subjectIds +
                '}';
    }
}
