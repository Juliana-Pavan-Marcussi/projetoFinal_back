package com.projetofinal.ticher.api.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.projetofinal.ticher.models.Student;

import javax.validation.constraints.*;

public class StudentRequest {

    @NotBlank
    @Size(min=2, max=200)
    private final String name;

    @NotBlank
    @Email
    private final String email;

    @NotBlank
    @Size(min=4)
    private final String cpf;

    @NotBlank
    @Size(min=4)
    private final String phone;

    @NotBlank
    @Size(min=4)
    private final String password;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public StudentRequest(String name, String email, String cpf, String phone, String password) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.phone = phone;
        this.password = password;
    }


    public Student toStudent(){
        return new Student(this.name, this.email, this.cpf, this.phone, this.password);
    }

}