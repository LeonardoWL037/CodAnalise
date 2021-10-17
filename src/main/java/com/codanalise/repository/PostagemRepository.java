package com.codanalise.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codanalise.model.Postagem;

public interface PostagemRepository extends JpaRepository<Postagem, Long>{

}
