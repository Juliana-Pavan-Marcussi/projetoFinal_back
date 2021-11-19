package com.projetofinal.ticher.repositories;

import com.projetofinal.ticher.models.TeacherAvailability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherAvailabilityRepository extends JpaRepository<TeacherAvailability, Long> {
}
