package com.projetofinal.ticher.api.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.projetofinal.ticher.models.Subject;
import com.projetofinal.ticher.models.Teacher;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class SubjectRequest {

    @NotBlank
    @Size(min=2, max=200)
    private final String name;

    @NotBlank
    @Size(min=2, max=200)
    private final String description;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public SubjectRequest(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Subject toSubject() {
        return new Subject(this.name, this.description);
    }

    @Override
    public String toString() {
        return "SubjectRequest{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
