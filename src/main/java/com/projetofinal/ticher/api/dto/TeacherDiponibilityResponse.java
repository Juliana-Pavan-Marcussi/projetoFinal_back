package com.projetofinal.ticher.api.dto;

import com.projetofinal.ticher.models.TeacherAvailability;

public class TeacherDiponibilityResponse {
    private String date;

    private String hours;

    private Double price;

    public TeacherDiponibilityResponse(TeacherAvailability teacherDiponibility) {
        this.date = teacherDiponibility.getDate().toString();
        this.hours = teacherDiponibility.getHours();
        this.price = teacherDiponibility.getPrice();
    }

    public String getDate() {
        return date;
    }

    public String getHours() {
        return hours;
    }

    public Double getPrice() {
        return price;
    }
}
