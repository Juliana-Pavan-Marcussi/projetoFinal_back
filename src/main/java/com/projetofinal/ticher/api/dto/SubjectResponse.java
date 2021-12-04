package com.projetofinal.ticher.api.dto;

import com.projetofinal.ticher.models.Subject;

public class SubjectResponse {
    private final String name;

    private final String description;

    public SubjectResponse(Subject subject) {
        this.name = subject.getName();
        this.description = subject.getDescription();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}