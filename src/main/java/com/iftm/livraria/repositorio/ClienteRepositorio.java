package com.iftm.livraria.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iftm.livraria.dominio.Cliente;

//possui os métodos para o CRUD(inserir, atualizar, deletar e editar)
@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Integer>, ClienteRepositorioCustom {

}


