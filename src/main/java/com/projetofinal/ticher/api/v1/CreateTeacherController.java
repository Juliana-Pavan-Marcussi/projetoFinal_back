package com.projetofinal.ticher.api.v1;

import com.projetofinal.ticher.api.dto.TeacherRequest;
import com.projetofinal.ticher.models.Teacher;
import com.projetofinal.ticher.repositories.TeacherRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/teachers")
public class CreateTeacherController {

    private final TeacherRepository teacherRepository;
    private final Logger log = LoggerFactory.getLogger(CreateTeacherController.class);

    @Autowired
    public CreateTeacherController(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> create(@RequestBody @Valid TeacherRequest request){
        log.info("[create.param.request] " + request.toString());

        Teacher teacher =  request.toTeacher();
        log.info("[request.toTeacher] " + teacher.toString());

        teacherRepository.save(teacher);

        return ResponseEntity.ok().build();
    }

}
