package com.codanalise.repository;

import com.codanalise.model.Carteira;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CarteiraRepository extends JpaRepository<Carteira , Long> {

    @Query("select c from Carteira c where c.mentor_id = ?1")
    Carteira streamCarteiraByMentor_id(long id);
}
