package com.projetofinal.ticher.api.dto;

import com.projetofinal.ticher.models.Evaluation;

public class EvaluationResponse {

    private final Integer score;

    private final String title;

    private final String description;

    public EvaluationResponse(Evaluation evaluation) {
        this.score = evaluation.getScore();
        this.title = evaluation.getTitle();
        this.description = evaluation.getDescription();
    }

    public Integer getScore() {
        return score;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
