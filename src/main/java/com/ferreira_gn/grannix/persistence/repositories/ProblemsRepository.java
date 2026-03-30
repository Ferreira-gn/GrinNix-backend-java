package com.ferreira_gn.grannix.persistence.repositories;

import com.ferreira_gn.grannix.persistence.entity.ProblemsEntity;
import com.ferreira_gn.grannix.services.ProblemsModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProblemsRepository extends JpaRepository<ProblemsEntity, UUID> {
}
