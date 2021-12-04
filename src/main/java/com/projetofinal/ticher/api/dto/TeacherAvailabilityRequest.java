package com.projetofinal.ticher.api.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.projetofinal.ticher.models.Teacher;
import com.projetofinal.ticher.models.TeacherAvailability;
import com.projetofinal.ticher.models.enums.StatusAvailability;
import com.projetofinal.ticher.repositories.TeacherRepository;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.Instant;
import java.time.LocalDate;

public class TeacherAvailabilityRequest {

    @Future
    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    private final LocalDate date;

    @NotNull
    @NotBlank
    @Pattern(regexp = "^([01]?[0-9]|2[0-3]):[0-5][0-9]$", message = "expected pattern: 00:00")
    private final String hours;

    @Future
    @NotNull
    private final Double price;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public TeacherAvailabilityRequest(LocalDate date, String hours, Double price) {
        this.date = date;
        this.hours = hours;
        this.price = price;
    }

    public TeacherAvailability toTeacherAvailability(Long idTeacher, TeacherRepository teacherRepository){

        Teacher teacher = teacherRepository
                .findById(idTeacher)
                .orElseThrow(() ->  new RuntimeException("teacher not found!"));

        return new TeacherAvailability(this.date, this.hours, this.price, teacher);
    }

}