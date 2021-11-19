package com.projetofinal.ticher.models.abstracts;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Login {

    @Column(nullable = false, unique = true)
    protected String email;

    @Column(nullable = false)
    protected String password;

}
