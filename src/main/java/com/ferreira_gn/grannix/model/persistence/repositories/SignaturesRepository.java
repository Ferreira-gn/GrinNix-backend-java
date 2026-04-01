package com.ferreira_gn.grannix.model.persistence.repositories;

import com.ferreira_gn.grannix.model.persistence.entity.SignaturesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SignaturesRepository extends JpaRepository<SignaturesEntity, UUID> {
    @Query("""
        SELECT s FROM SignaturesEntity s
        INNER JOIN s.problem p
        INNER JOIN s.language l
        WHERE p.id = :problemId
        AND l.id = :languageId
    """)
    Optional<SignaturesEntity> findByLanguageIdAndProblemId(@Param("languageId") UUID languageId, @Param("problemId") UUID problemId);
}