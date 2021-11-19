package com.projetofinal.ticher.api.v1;

import com.projetofinal.ticher.api.dto.StudentRequest;
import com.projetofinal.ticher.models.Student;
import com.projetofinal.ticher.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/students")
public class CreateStudentController {

    private final StudentRepository studentRepository;

    @Autowired
    public CreateStudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> create(@RequestBody @Valid StudentRequest request){
        Student student = request.toStudent();
        studentRepository.save(student);
        return ResponseEntity.ok().build();
    }

}
