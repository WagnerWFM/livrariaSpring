package com.iftm.livraria.repositorio;

import java.util.List;

import com.iftm.livraria.dominio.Cliente;

public interface ClienteRepositorioCustom {

	public Cliente buscarNomeExato(String nome);
	public List<Cliente> buscarTodosOrdenadosPorNome();
	public List<Cliente> buscarPorNome(String trecho);
	public List<Cliente> buscarTodos();
}
