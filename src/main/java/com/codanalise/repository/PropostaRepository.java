package com.codanalise.repository;

import com.codanalise.model.Proposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PropostaRepository extends JpaRepository<Proposta, Long>{


    @Query("select p from Proposta p where p.mentor.id = ?1")
    List<Proposta> findPropostaByMentor(long id);

}
