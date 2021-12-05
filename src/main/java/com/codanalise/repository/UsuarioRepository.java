package com.codanalise.repository;

import com.codanalise.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	Optional<Usuario> findByEmail(String email);

	@Query("select u from Usuario u where u.nome like Upper (concat(:Nome,'%'))")
	Optional<Usuario> findByNomeLike(@Param("Nome") String Nome);

}
