package com.projetofinal.ticher.api.v1;

import com.projetofinal.ticher.api.dto.TeacherAvailabilityRequest;
import com.projetofinal.ticher.models.TeacherAvailability;
import com.projetofinal.ticher.repositories.TeacherAvailabilityRepository;
import com.projetofinal.ticher.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("availabilities")
public class CreateTeacherAvailabilityController {

    private final TeacherRepository teacherRepository;
    private final TeacherAvailabilityRepository teacherAvailabilityRepository;

    @Autowired
    public CreateTeacherAvailabilityController(TeacherRepository teacherRepository, TeacherAvailabilityRepository teacherAvailabilityRepository) {
        this.teacherRepository = teacherRepository;
        this.teacherAvailabilityRepository = teacherAvailabilityRepository;
    }

    @PostMapping("/{idTeacher}")
    @Transactional
    public ResponseEntity<?> create(@RequestBody @Valid TeacherAvailabilityRequest request, @PathVariable Long idTeacher){
        TeacherAvailability availability = request.toTeacherAvailability(idTeacher, teacherRepository);
        teacherAvailabilityRepository.save(availability);
        return ResponseEntity.ok().build();
    }

}
