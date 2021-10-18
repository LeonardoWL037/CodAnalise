package com.codanalise.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codanalise.model.Mentor;

public interface MentorRepository extends JpaRepository<Mentor, Long>{

	void save(long id);

//	Optional<Mentor> findbyUsuario(Long usuario);
	
//	Optional<Mentor> findByUsuario(Long usuario);

	Optional<Mentor> findByUsuarioId(Long usuario_id);

//	Mentor findByUsuarioId(Long usuario_id);

	

}
