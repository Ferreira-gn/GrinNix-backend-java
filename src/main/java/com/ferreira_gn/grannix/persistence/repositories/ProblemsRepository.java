package com.ferreira_gn.grannix.persistence.repositories;

import com.ferreira_gn.grannix.persistence.entity.ProblemsEntity;
import com.ferreira_gn.grannix.services.ProblemsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProblemsRepository extends JpaRepository<ProblemsEntity, UUID> {
}
