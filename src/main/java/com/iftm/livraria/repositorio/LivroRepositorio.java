package com.iftm.livraria.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iftm.livraria.dominio.Cliente;

@Repository
public interface LivroRepositorio extends JpaRepository<Cliente, Integer>, ClienteRepositorioCustom {

}


