package com.codanalise.repository;

import com.codanalise.model.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostagemRepository extends JpaRepository<Postagem, Long>{


    @Query("select p from Postagem p left join p.tags tags where UPPER(tags.linguagem) = (concat(?1,'%'))")
    List<Postagem> findPostagemByTagsLinguagem(String tag);
}
