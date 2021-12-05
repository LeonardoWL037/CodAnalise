package com.codanalise.repository;

import com.codanalise.model.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MentorRepository extends JpaRepository<Mentor, Long>{

	void save(long id);

//	Optional<Mentor> findbyUsuario(Long usuario);
	
//	Optional<Mentor> findByUsuario(Long usuario);

	Optional<Mentor> findByUsuarioId(Long usuario_id);

//	Mentor findByUsuarioId(Long usuario_id);

	

}
