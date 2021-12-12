package com.codanalise.repository;

import com.codanalise.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	Optional<Usuario> findByEmail(String email);

	@Query("select u from Usuario u where Upper (u.nome) like Upper (concat(:Nome,'%'))")
	List<Usuario> findAllByNomeLike(@Param("Nome") String Nome);


	@Query("select distinct u from Usuario u left join u.linguagem linguagem where upper (concat(u.nome,' ',u.sobrenome)) like upper(concat(?1, '%'))  or upper(linguagem.ferramenta) like concat(?1,'%')")
	List<Usuario> findByNomeOrSobrenomeOrLinguagemFerramentaContaining(String busca);

}
