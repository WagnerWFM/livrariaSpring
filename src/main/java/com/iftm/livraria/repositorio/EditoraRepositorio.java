package com.iftm.livraria.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iftm.livraria.dominio.Editora;

@Repository
public interface EditoraRepositorio extends JpaRepository<Editora, Integer> {

}


