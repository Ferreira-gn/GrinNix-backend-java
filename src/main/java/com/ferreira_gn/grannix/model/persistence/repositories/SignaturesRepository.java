package com.ferreira_gn.grannix.model.persistence.repositories;

import com.ferreira_gn.grannix.model.persistence.entity.SignaturesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SignaturesRepository extends JpaRepository<SignaturesEntity, UUID> {
}