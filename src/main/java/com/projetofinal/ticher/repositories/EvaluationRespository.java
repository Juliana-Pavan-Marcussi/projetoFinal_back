package com.projetofinal.ticher.repositories;

import com.projetofinal.ticher.models.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvaluationRespository extends JpaRepository<Evaluation, Long> {
}
