package com.projetofinal.ticher.api.v1;

import com.projetofinal.ticher.api.dto.SubjectRequest;
import com.projetofinal.ticher.models.Subject;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("/subjects")
public class CreateSubjectController {

    @PersistenceContext
    private final EntityManager entityManager;

    public CreateSubjectController(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> create(@Valid @RequestBody SubjectRequest request){
        Subject subject = request.toSubject();
        entityManager.persist(subject);
        return ResponseEntity.ok().build();
    }
}
