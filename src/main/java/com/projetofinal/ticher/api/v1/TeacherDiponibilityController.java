package com.projetofinal.ticher.api.v1;

import com.projetofinal.ticher.api.dto.TeacherDiponibilityResponse;
import com.projetofinal.ticher.config.exceptions.CustomException;
import com.projetofinal.ticher.models.TeacherAvailability;
import com.projetofinal.ticher.repositories.TeacherAvailabilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/teacherDisponibility")
public class TeacherDiponibilityController {

    private final TeacherAvailabilityRepository teacherAvailabilityRepository;

    @Autowired
    public TeacherDiponibilityController(TeacherAvailabilityRepository teacherAvailabilityRepository) {
        this.teacherAvailabilityRepository = teacherAvailabilityRepository;
    }

    @GetMapping(value = "/{id}")
    @Transactional
    private ResponseEntity<?> findById(@PathVariable Long id) {
        TeacherAvailability teacherDiponibility = teacherAvailabilityRepository.findById(id).orElseThrow(() -> new CustomException("Teacher Diponibility not found!", HttpStatus.NOT_FOUND));
        return ResponseEntity.ok().body(new TeacherDiponibilityResponse(teacherDiponibility));
    }
}
