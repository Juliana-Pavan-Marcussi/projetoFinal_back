package com.projetofinal.ticher.api.v1;

import com.projetofinal.ticher.api.dto.EvaluationRequest;
import com.projetofinal.ticher.models.Evaluation;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("/evaluations")
public class CreateEvaluationController {

    @PersistenceContext
    private final EntityManager entityManager;

    public CreateEvaluationController(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @PostMapping("/{teacherId}/{studentId}")
    @Transactional
    public ResponseEntity<?> create(@Valid @RequestBody EvaluationRequest request, @PathVariable Long teacherId, @PathVariable Long studentId){
        Evaluation evaluation = request.toEvaluation(studentId, teacherId, entityManager);
        entityManager.persist(evaluation);

        return ResponseEntity.ok().build();
    }

}
