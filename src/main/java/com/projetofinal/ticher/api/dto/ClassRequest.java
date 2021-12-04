package com.projetofinal.ticher.api.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.projetofinal.ticher.config.annotations.ExistsValid;
import com.projetofinal.ticher.models.Class;
import com.projetofinal.ticher.models.Student;
import com.projetofinal.ticher.models.TeacherAvailability;
import com.projetofinal.ticher.models.enums.StatusAvailability;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotNull;

public class ClassRequest {

    @ExistsValid(klass = Student.class, field = "id")
    @NotNull
    private final Long idStudent;

    @ExistsValid(klass = TeacherAvailability.class, field = "id")
    @NotNull
    private final Long idTeacherAvailability;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public ClassRequest(Long idStudent, Long idTeacherAvailability) {
        this.idStudent = idStudent;
        this.idTeacherAvailability = idTeacherAvailability;
    }

    public Class toClass(EntityManager entityManager) {
        Student student = entityManager.find(Student.class, idStudent);
        TeacherAvailability teacherAvailability = entityManager.find(TeacherAvailability.class, idTeacherAvailability);
        if(teacherAvailability.getStatusAvailability() == StatusAvailability.CLOSE){
            throw new RuntimeException("UNAVAILABLE CLASS!");
        }
        teacherAvailability.setStatusAvailability(StatusAvailability.CLOSE);
        return new Class(teacherAvailability, student);
    }
}
