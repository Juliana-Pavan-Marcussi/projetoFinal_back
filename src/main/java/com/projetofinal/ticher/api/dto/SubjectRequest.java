package com.projetofinal.ticher.api.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.projetofinal.ticher.models.Subject;
import com.projetofinal.ticher.models.Teacher;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

public class SubjectRequest {

    @NotBlank
    @Max(150)
    private final String name;

    @NotBlank
    @Max(1000)
    private final String description;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public SubjectRequest(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Subject toSubject(Teacher teacher){
        return new Subject(this.name, this.description, teacher);
    }

    @Override
    public String toString() {
        return "SubjectRequest{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
