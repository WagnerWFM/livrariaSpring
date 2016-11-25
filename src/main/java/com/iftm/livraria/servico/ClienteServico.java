package com.iftm.livraria.servico;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iftm.livraria.dominio.Cliente;
import com.iftm.livraria.repositorio.ClienteRepositorio;
import com.iftm.livraria.servico.excecoes.NaoEncontradoException;
import com.iftm.livraria.servico.excecoes.ServicoException;
import com.iftm.livraria.servico.excecoes.ValidacaoException;


@Service
public class ClienteServico {

	@Autowired
	private ClienteRepositorio repo;

	public void validar(Cliente x) {
		List<String> erros = new ArrayList<>();
		
		if (x.getNome()==null) {
			erros.add("Favor preencher o campo nome");
		}
		if (x.getCpf()==null) {
			erros.add("Favor preencher o campo cpf");
		}
		if (x.getFone()==null) {
			erros.add("Favor preencher um valor válido para o fone");
		}
		if (x.getEmail()==null) {
			erros.add("Favor preencher um valor válido para o e-mail");
		}
		if (x.getNascimento()==null) {
			erros.add("Favor preencher um valor válido para a data de nascimento");
		}
		if (x.getRendaMensal()==null) {
			erros.add("Favor preencher um valor válido para a renda mensal");
		}
		
		if (!erros.isEmpty()) {
			throw new ValidacaoException("Erro de validação", erros);
		}
	}
	
	public Cliente inserir(Cliente x) throws ServicoException {
		Cliente aux = repo.buscarNomeExato(x.getNome());
		if (aux != null) {
			throw new ServicoException("Já existe um cliente com esse nome!", 1);
		}
		validar(x);
		return repo.save(x);
	}

	public Cliente atualizar(Cliente x) throws ServicoException {
		Cliente aux = repo.findOne(x.getCodCliente());
		if (aux == null) {
			throw new NaoEncontradoException("Cliente  não encontrado!", 1);
		}
		aux = repo.buscarNomeExato(x.getNome());
		if (aux != null && aux.getCodCliente()!=x.getCodCliente()) {//pode inserir clientes com mesmo nome, mas com ID igual.
																	//Posso atualizar o mesmo nome,nao posso criar outro campo com nome igual.
			throw new ServicoException("Já existe um outro cliente com esse nome!", 1);
		}
		validar(x);
		return repo.save(x);
	}

	public void excluir(int cod) throws ServicoException {
		Cliente cli = repo.findOne(cod);
		if (cli == null) {
			throw new NaoEncontradoException("Cliente não encontrado!", 1);
		}
		if (!cli.getEmprestimos().isEmpty()) {	//verifica se cliente possui empréstimos
			throw new ServicoException("Exclusão não permitida: este cliente possui empréstimos!", 2);
		}
		repo.delete(cli);
	}
	
	public Cliente buscar(int cod) {
		Cliente cli = repo.findOne(cod);
		if (cli == null) {
			throw new NaoEncontradoException("Cliente não encontrado!", 1);
		}
		return cli;
	}
	
	public List<Cliente> buscarTodos() {
		List<Cliente> cli = repo.findAll();
		if (cli == null) {
			throw new NaoEncontradoException("Clientes não encontrados", 1);
		}
		
		return cli;
	}
	
	//métodos abaixo verificar se irá ser usado.
	public List<Cliente> buscarTodosOrdenadosPorNome() {
		return repo.buscarTodosOrdenadosPorNome();
	}
	
	public List<Cliente> buscarPorNome(String trecho) {
		return repo.buscarPorNome(trecho);
	}
}
