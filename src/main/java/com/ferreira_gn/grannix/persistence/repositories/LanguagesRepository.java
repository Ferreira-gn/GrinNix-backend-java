package com.ferreira_gn.grannix.persistence.repositories;

import com.ferreira_gn.grannix.persistence.entity.LanguagesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LanguagesRepository extends JpaRepository<LanguagesEntity, UUID> {
}
