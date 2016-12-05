package com.iftm.livraria.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iftm.livraria.dominio.ItemEmprestimo;

@Repository
public interface ItemEmprestimoRepositorio extends JpaRepository<ItemEmprestimo, Integer> {

}


