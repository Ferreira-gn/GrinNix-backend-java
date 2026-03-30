package com.ferreira_gn.grannix.model.persistence.repositories;

import com.ferreira_gn.grannix.model.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    @Query("""
            SELECT COUNT(u) > 0 FROM UserEntity u
            WHERE u.email = :email
    """)
    boolean existsUserByEmail(@Param("email") String email);
}
