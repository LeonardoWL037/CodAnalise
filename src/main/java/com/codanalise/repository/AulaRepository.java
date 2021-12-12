package com.codanalise.repository;

import com.codanalise.model.Aula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AulaRepository extends JpaRepository<Aula, Long> {

    @Query("select a from Aula a where a.id_mentor = ?1")
    List<Aula> findAulaById_mentor(long id);

    @Query("select a from Aula a where a.id_usuario = ?1")
    List<Aula> findAulaById_usuario(long id);
}
