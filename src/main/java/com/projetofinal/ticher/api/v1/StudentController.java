package com.projetofinal.ticher.api.v1;

import com.projetofinal.ticher.api.dto.StudentResponse;
import com.projetofinal.ticher.config.exceptions.CustomException;
import com.projetofinal.ticher.models.Student;
import com.projetofinal.ticher.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping(value = "/{id}")
    @Transactional
    private ResponseEntity<?> findById(@PathVariable Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new CustomException("Student not found!", HttpStatus.NOT_FOUND));
        return ResponseEntity.ok().body(new StudentResponse(student));
    }

    @GetMapping
    public ResponseEntity<List<Student>> findAll() {
        List<Student> students = studentRepository.findAll();
        return ResponseEntity.ok().body(students);
    }
}
