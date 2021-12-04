package com.projetofinal.ticher.api.v1;

import com.projetofinal.ticher.api.dto.ClassRequest;
import com.projetofinal.ticher.models.Class;
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
@RequestMapping("/class")
public class CreateClassController {

    @PersistenceContext
    private final EntityManager entityManager;

    public CreateClassController(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> create(@RequestBody @Valid ClassRequest request) {
        Class klass = request.toClass(entityManager);
        entityManager.persist(klass);
        return ResponseEntity.ok().build();
    }
}
