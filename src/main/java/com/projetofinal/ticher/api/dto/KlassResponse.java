package com.projetofinal.ticher.api.dto;

import com.projetofinal.ticher.models.Class;

public class KlassResponse {
    private final String teacher;

    private final String student;

    private final String data;

    private final String hora;

    private final String emailTeacher;

    private final String emailStudent;

    public KlassResponse(Class klass) {
        this.teacher = klass.getTeacherAvailability().getTeacher().getName();
        this.student = klass.getStudent().getName();
        this.data = klass.getTeacherAvailability().getDate().toString();
        this.hora = klass.getTeacherAvailability().getHours();
        this.emailTeacher = klass.getTeacherAvailability().getTeacher().getEmail();
        this.emailStudent = klass.getStudent().getEmail();
    }

    public String getTeacher() {
        return teacher;
    }

    public String getStudent() {
        return student;
    }

    public String getData() {
        return data;
    }

    public String getHora() {
        return hora;
    }

    public String getEmailTeacher() {
        return emailTeacher;
    }

    public String getEmailStudent() {
        return emailStudent;
    }
}
