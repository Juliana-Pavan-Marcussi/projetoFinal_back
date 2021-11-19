package com.projetofinal.ticher.api.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.projetofinal.ticher.models.Evaluation;
import com.projetofinal.ticher.models.Student;
import com.projetofinal.ticher.models.Teacher;

import javax.persistence.EntityManager;
import javax.validation.constraints.*;

public class EvaluationRequest {

    @NotNull
    @NotBlank
    @Size(max = 100)
    private final String title;

    @NotNull
    @NotBlank
    @Size(max = 500)
    private final String description;

    @Min(1)
    @Max(5)
    @NotNull
    private final Integer score;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public EvaluationRequest(String title, String description, Integer score) {
        this.title = title;
        this.description = description;
        this.score = score;
    }

    public Evaluation toEvaluation(Long studentId, Long teacherId, EntityManager entityManager){
        Student student = entityManager.find(Student.class, studentId);
        Teacher teacher = entityManager.find(Teacher.class, teacherId);
        return new Evaluation(this.title, this.description, this.score, student, teacher);
    }
}
