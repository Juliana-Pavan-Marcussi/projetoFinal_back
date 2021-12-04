package com.projetofinal.ticher.api.v1;

import com.projetofinal.ticher.api.dto.KlassResponse;
import com.projetofinal.ticher.config.exceptions.CustomException;
import com.projetofinal.ticher.models.Class;
import com.projetofinal.ticher.repositories.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/class")
public class ClassController {

    private final ClassRepository classRepository;

    @Autowired
    public ClassController(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    @GetMapping(value = "/{id}")
    @Transactional
    private ResponseEntity<?> findById(@PathVariable Long id) {
        Class klass = classRepository.findById(id).orElseThrow(() -> new CustomException("Class not found!", HttpStatus.NOT_FOUND));
        return ResponseEntity.ok().body(new KlassResponse(klass));
    }
}
