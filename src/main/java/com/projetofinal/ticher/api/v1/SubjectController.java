package com.projetofinal.ticher.api.v1;

import com.projetofinal.ticher.api.dto.SubjectResponse;
import com.projetofinal.ticher.config.exceptions.CustomException;
import com.projetofinal.ticher.models.Student;
import com.projetofinal.ticher.models.Subject;
import com.projetofinal.ticher.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    private final SubjectRepository subjectRepository;

    @Autowired
    public SubjectController(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @GetMapping(value = "/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    @Transactional
    private ResponseEntity<?> findById(@PathVariable Long id) {
        Subject subject = subjectRepository.findById(id).orElseThrow(() -> new CustomException("Subject not found!", HttpStatus.NOT_FOUND));
        return ResponseEntity.ok().body(new SubjectResponse(subject));
    }

    @GetMapping
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<Subject>> findAll() {
        List<Subject> subjects = subjectRepository.findAll();
        return ResponseEntity.ok().body(subjects);
    }
}
