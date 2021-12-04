package com.projetofinal.ticher.api.v1;

import com.projetofinal.ticher.api.dto.EvaluationResponse;
import com.projetofinal.ticher.config.exceptions.CustomException;
import com.projetofinal.ticher.models.Evaluation;
import com.projetofinal.ticher.repositories.EvaluationRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/evaluation")
public class EvaluationController {

    private final EvaluationRespository evaluationRespository;

    @Autowired
    public EvaluationController(EvaluationRespository evaluationRespository) {
        this.evaluationRespository = evaluationRespository;
    }

    @GetMapping(value = "/{id}")
    @Transactional
    private ResponseEntity<?> findById(@PathVariable Long id) {
        Evaluation evaluation = evaluationRespository.findById(id).orElseThrow(() -> new CustomException("Evaluation not found!", HttpStatus.NOT_FOUND));
        return ResponseEntity.ok().body(new EvaluationResponse(evaluation));
    }
}
