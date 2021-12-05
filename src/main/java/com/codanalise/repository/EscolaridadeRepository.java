package com.codanalise.repository;


import com.codanalise.model.Escolaridade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EscolaridadeRepository extends JpaRepository<Escolaridade, Long> {


//    @Query("select e from Escolaridade e where e.usuario_id = ?1")
//    public Optional<Escolaridade> findByUsuario_id(Long usuario_id);

    @Query("select e from Escolaridade e where e.usuario_id = ?1")
    public List<Escolaridade> findByUsuario_id(Long usuario_id);
}
