package com.codanalise.repository;

import com.codanalise.model.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostagemRepository extends JpaRepository<Postagem, Long>{


    @Query("select p from Postagem p left join p.tags tags where UPPER(tags.linguagem) = (concat(?1,'%'))")
    List<Postagem> findPostagemByTagsLinguagem(String tag);


    @Query("select distinct p from Postagem p left join p.tags tags where upper(tags.linguagem) like upper(concat(?1, '%')) or Upper(concat(p.autor.nome,' ', p.autor.sobrenome)) like upper(concat(?1, '%'))")
    List<Postagem> findPostagemByTagsLinguagemOrAutorNomeContaining(String busca);


    @Query("select p from Postagem p where p.autor.id = ?1")
    List<Postagem> findPostagemByAutorId(long id);
}
