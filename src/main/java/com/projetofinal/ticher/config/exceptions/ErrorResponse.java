package com.projetofinal.ticher.config.exceptions;

public class ErrorResponse {
    private final String campo;
    private final String error;

    public String getCampo() {
        return campo;
    }

    public ErrorResponse(String campo, String error) {
        this.campo = campo;
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
