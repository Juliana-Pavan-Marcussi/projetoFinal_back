package com.projetofinal.ticher.config.exceptions;

public class GlobalErrorResponse {

    private final String error;

    public GlobalErrorResponse(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

}
