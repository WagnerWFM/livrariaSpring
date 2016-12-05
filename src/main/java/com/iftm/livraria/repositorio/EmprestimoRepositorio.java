package com.iftm.livraria.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iftm.livraria.dominio.Emprestimo;

@Repository
public interface EmprestimoRepositorio extends JpaRepository<Emprestimo, Integer> {

}


