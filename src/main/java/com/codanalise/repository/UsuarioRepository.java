package com.codanalise.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.codanalise.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	Optional<Usuario> findByEmail(String email);

//	@Query("select u from Usuario u where u.nome like Upper (concat(:Nome,'%'))")
	@Query("select u from Usuario u where u.nome like Upper (:Nome + %)")
	Optional<Usuario> findByNomeLike(@Param("Nome") String Nome);

}
