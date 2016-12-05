
package com.iftm.livraria.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iftm.livraria.dominio.Categoria;

@Repository
public interface CategoriaRepositorio extends JpaRepository<Categoria, Integer> {

}


