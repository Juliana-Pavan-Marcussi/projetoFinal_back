package com.projetofinal.ticher.config.annotations;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ExistsValidator implements ConstraintValidator<ExistsValid, Object> {

    private String field;
    private Class<?> klass;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void initialize(ExistsValid constraintAnnotation) {
        this.field = constraintAnnotation.field();
        this.klass = constraintAnnotation.klass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Query query = entityManager.createQuery("SELECT 1 FROM " + klass.getName() + " WHERE " + field + "=:value" );
        query.setParameter("value", value);
        List<?> resultQuery = query.getResultList();

        return !resultQuery.isEmpty();
    }
}
